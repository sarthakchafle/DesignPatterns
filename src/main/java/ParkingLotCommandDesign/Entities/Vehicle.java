package ParkingLotCommandDesign.Entities;

import ParkingLotCommandDesign.DurationType;
import ParkingLotCommandDesign.ParkingFeeStrategy;

public abstract class Vehicle {
    private final String registrationNumber;
    private String vehicleType;
    private final String color;
    private ParkingFeeStrategy parkingFeeStrategy;

    public Vehicle(String vehicleType,String registrationNumber, String color,ParkingFeeStrategy parkingFeeStrategy) {
        this.vehicleType=vehicleType;
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }
    // Method to calculate parking fee based on duration and duration type
    public double calculateFee(int duration, DurationType durationType) {
        return parkingFeeStrategy.calculateFee(vehicleType, duration, durationType);
    }
}
