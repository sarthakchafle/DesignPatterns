package ParkingLotCommandDesign.Entities;

import ParkingLotCommandDesign.ParkingFeeStrategy;

public class Truck extends Vehicle {
    public Truck(String vehicleType, String registrationNumber, String color, ParkingFeeStrategy parkingFeeStrategy) {
        super(vehicleType,registrationNumber, color,parkingFeeStrategy);
    }
}
