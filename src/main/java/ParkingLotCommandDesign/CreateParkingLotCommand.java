package ParkingLotCommandDesign;

public class CreateParkingLotCommand implements Command{
    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: create_parking_lot <capacity>");
            return;
        }
        int capacity;
        try {
            capacity = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid capacity: " + args[1]);
            return;
        }
        ParkingLot parkingLot = null;
        parkingLot=ParkingLot.initialize(capacity);
        System.out.println("Created a parking lot with " +capacity + " slots.");
    }
}
