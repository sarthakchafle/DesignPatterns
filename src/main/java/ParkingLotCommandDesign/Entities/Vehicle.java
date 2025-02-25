package ParkingLotCommandDesign.Entities;

public abstract class Vehicle {
    private final String registrationNumber;
    private final String color;

    public Vehicle(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }
}
