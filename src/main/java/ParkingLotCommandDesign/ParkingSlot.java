package ParkingLotCommandDesign;

import ParkingLotCommandDesign.Entities.Vehicle;

public class ParkingSlot implements Comparable<ParkingSlot>{
    private final int slotNumber;
    private boolean isAvailable;
    private Vehicle parkedVehicle;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isAvailable = true;
        this.parkedVehicle = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isAvailable = false;
    }

    public void leave() {
        this.parkedVehicle = null;
        this.isAvailable = true;
    }

    @Override
    public int compareTo(ParkingSlot other) {
        return Integer.compare(this.slotNumber, other.slotNumber);
    }
}
