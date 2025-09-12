package ParkingLotDesign;

public interface VehicleFactory {
    Vehicle createVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) throws Exception;
}
