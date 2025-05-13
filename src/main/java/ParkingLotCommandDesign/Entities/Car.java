package ParkingLotCommandDesign.Entities;

import ParkingLotCommandDesign.ParkingFeeStrategy;

public class Car extends Vehicle {
    public Car(String vehicleType,String registrationNumber, String color, ParkingFeeStrategy parkingFeeStrategy) {
        super("Car",registrationNumber, color,parkingFeeStrategy);
    }
}
