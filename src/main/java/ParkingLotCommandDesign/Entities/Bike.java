package ParkingLotCommandDesign.Entities;

import ParkingLotCommandDesign.ParkingFeeStrategy;

public class Bike extends Vehicle {
    public Bike(String vehicleType, String registrationNumber, String color, ParkingFeeStrategy parkingFeeStrategy) {
        super(vehicleType,registrationNumber, color,parkingFeeStrategy);
    }
}
