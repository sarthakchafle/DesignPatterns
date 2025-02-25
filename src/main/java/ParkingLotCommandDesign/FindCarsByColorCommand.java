package ParkingLotCommandDesign;

public class FindCarsByColorCommand implements Command{
    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: find_cars_by_color <color>");
            return;
        }
        ParkingLot parkingLot = ParkingLot.getInstance();
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created.");
            return;
        }
        parkingLot.findCarsByColor(args[1]);
    }
}
