package ParkingLotCommandDesign;

public class LeaveCommand implements Command{
    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: leave <slot_number>");
            return;
        }
        int slotNumber;
        try {
            slotNumber = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid slot number: " + args[1]);
            return;
        }
        ParkingLot parkingLot = ParkingLot.getInstance();
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created.");
            return;
        }
        parkingLot.leave(slotNumber);
    }
}
