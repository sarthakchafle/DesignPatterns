package ParkingLotCommandDesign;

public class StatusCommand implements Command{
    @Override
    public void execute(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        if (parkingLot == null) {
            System.out.println("Parking lot has not been created.");
            return;
        }
        parkingLot.status();
    }
}
