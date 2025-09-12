package ParkingLotDesign;

public interface ParkingFeeStrategy {
    double calculateFee(String vehicleType,double duration);
}
