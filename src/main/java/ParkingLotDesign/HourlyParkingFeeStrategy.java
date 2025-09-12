package ParkingLotDesign;

public class HourlyParkingFeeStrategy implements ParkingFeeStrategy{

    @Override
    public double calculateFee(String vehicleType, double duration) {
        if(vehicleType.equalsIgnoreCase("bike")){
            return 40.0 * duration;
        }
        else if(vehicleType.equalsIgnoreCase("car")){
            return 60.0 * duration;
        }
        return 50.0 * duration;
    }
}