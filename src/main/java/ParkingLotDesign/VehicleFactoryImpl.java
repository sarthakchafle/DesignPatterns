package ParkingLotDesign;

public class VehicleFactoryImpl implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String licensePlate, String vehicleType, ParkingFeeStrategy feeStrategy) throws Exception {
         switch (vehicleType){
             case "car":
                 return new Car(licensePlate,vehicleType,feeStrategy);
             case "bike":
                 return new Bike(licensePlate,vehicleType,feeStrategy);
             case "truck":
                 return new Truck(licensePlate,vehicleType,feeStrategy);
             default:
                 throw new Exception("Invalid vehicle type");
         }
    }
}
