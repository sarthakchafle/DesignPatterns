package ParkingLotDesign;

public class HeavyVehicleParkingFeeStrategy implements ParkingFeeStrategy{
    @Override
    public double calculateFee(String vehicleType, double duration) {
        if(vehicleType.equalsIgnoreCase("truck")){
            return 100.0 * duration;
        }
        return 0.0;
    }
}