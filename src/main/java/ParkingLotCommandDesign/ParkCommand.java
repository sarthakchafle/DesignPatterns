package ParkingLotCommandDesign;

import ParkingLotCommandDesign.Entities.Car;

public class ParkCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: park <registration_number> <color>");
            return;
        }
        ParkingLot parkingLot = ParkingLot.getInstance();
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created.");
            return;
        }
        Car car = new Car(args[1], args[2]);
        parkingLot.park(car);
    }
}
