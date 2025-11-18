package ParkingLotCommandDesign;

import ParkingLotCommandDesign.Entities.Vehicle;

import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;
    private int capacity;
    private final TreeSet<ParkingSlot> availableSlots = new TreeSet<>();
    private final Map<Integer, ParkingSlot> occupiedSlots = new HashMap<>();

    // Private constructor to prevent instantiation
    private ParkingLot(int capacity) {
        this.capacity = capacity;
        for (int i = 1; i <= capacity; i++) {
            availableSlots.add(new ParkingSlot(i));
        }
        System.out.println("Created a parking lot with " + capacity + " slots.");
    }

    // Synchronized method to initialize the instance with capacity
    public static synchronized ParkingLot initialize(int capacity) {
        if (instance == null) {
            instance = new ParkingLot(capacity);
        } else {
            System.out.println("ParkingLot is already initialized.");

        }
        return instance;
    }

    // Method to get the existing instance
    public static ParkingLot getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ParkingLot has not been initialized. Call initialize() first.");
        }
        return instance;
    }


    public ParkingSlot park(Vehicle vehicle) {
        if (availableSlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full.");
            return null;
        }
        ParkingSlot slot = availableSlots.pollFirst();
        slot.park(vehicle);
        occupiedSlots.put(slot.getSlotNumber(), slot);
        System.out.println("Allocated slot number: " + slot.getSlotNumber());
        return slot;
    }

    public void leave(int slotNumber) {
        ParkingSlot slot = occupiedSlots.remove(slotNumber);
        if (slot == null) {
            System.out.println("Slot number " + slotNumber + " is already empty.");
            return;
        }
        double carFee = slot.getParkedVehicle().calculateFee(2, DurationType.HOURS);
        slot.leave();
        availableSlots.add(slot);

        System.out.println("Slot number " + slotNumber + " is free.");
        System.out.println("Parking fee is Rs "+carFee);
    }

    public void status() {
        System.out.println("Slot No.    Registration No    Colour");
        for (ParkingSlot slot : occupiedSlots.values()) {
            Vehicle vehicle = slot.getParkedVehicle();
            System.out.printf("%-11d%-19s%s%n", slot.getSlotNumber(), vehicle.getRegistrationNumber(), vehicle.getColor());
        }
    }

    public void findCarsByColor(String color) {
        List<String> cars = new ArrayList<>();
        for (ParkingSlot slot : occupiedSlots.values()) {
            Vehicle vehicle = slot.getParkedVehicle();
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                cars.add(vehicle.getRegistrationNumber());
            }
        }
        if (cars.isEmpty()) {
            System.out.println("No cars with color " + color + " found.");
        } else {
            System.out.println(String.join(", ", cars));
        }
    }

    public void findSlotsByColor(String color) {
        List<Integer> slots = new ArrayList<>();
        for (Map.Entry<Integer, ParkingSlot> entry : occupiedSlots.entrySet()) {
            Vehicle vehicle = entry.getValue().getParkedVehicle();
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                slots.add(entry.getKey());
            }
        }
        if (slots.isEmpty()) {
            System.out.println("No slots with cars of color " + color + " found.");
        } else {
            System.out.println("Slots with cars of color " + color + ": " + slots);
        }
    }

    public void findSlotByRegNumber(String regNumber) {
        for (Map.Entry<Integer, ParkingSlot> entry : occupiedSlots.entrySet()) {
            Vehicle vehicle = entry.getValue().getParkedVehicle();
            if (vehicle.getRegistrationNumber().equalsIgnoreCase(regNumber)) {
                System.out.println("Car with registration number " + regNumber + " is parked at slot " + entry.getKey() + ".");
                return;
            }
        }
        System.out.println("Car with registration number " + regNumber + " not found.");
    }

}
