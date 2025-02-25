package ParkingLotCommandDesign;

public class FindSlotByRegNumberCommand implements Command{
    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: find_slot_by_reg_number <registration_number>");
            return;
        }
        ParkingLot parkingLot = ParkingLot.getInstance();
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created.");
            return;
        }
        parkingLot.findSlotByRegNumber(args[1]);
    }
}
