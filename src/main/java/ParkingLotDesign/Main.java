package ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new CarParkingSpot(1,"car"));
        parkingSpots.add(new CarParkingSpot(2,"car"));
        parkingSpots.add(new BikeParkingSpot(3,"bike"));
        parkingSpots.add(new BikeParkingSpot(4,"bike"));
        // Initialize parking lot
        ParkingLot parkingLot = new ParkingLot(parkingSpots);
        // Create fee strategies
        ParkingFeeStrategy hourlyRateStrategy = new HourlyParkingFeeStrategy();
        ParkingFeeStrategy premiumRateStrategy = new HeavyVehicleParkingFeeStrategy();
        VehicleFactory vehicleFactory = new VehicleFactoryImpl();
        // Create vehicles using Factory Pattern with fee strategies
        Vehicle car1 = vehicleFactory.createVehicle("CAR123","car",hourlyRateStrategy);
        Vehicle car2 = vehicleFactory.createVehicle("CAR345","car",hourlyRateStrategy);

        Vehicle bike1 = vehicleFactory.createVehicle("Bike", "bike",hourlyRateStrategy);
        Vehicle bike2 = vehicleFactory.createVehicle("Bike", "bike", hourlyRateStrategy);

        // Park vehicles
        ParkingSpot carSpot = parkingLot.parkVehicle(car1);
        ParkingSpot bikeSpot = parkingLot.parkVehicle(bike1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method for your vehicle:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        int paymentMethod = scanner.nextInt();
        // Process payments using Strategy Patterns
        if (carSpot != null) {
            // Calculate fee using the specific strategy for the vehicle
            double carFee = car1.getParkingFeeStrategy().calculateFee("car",5);
            PaymentStrategy carPaymentStrategy =
                    getPaymentStrategy(paymentMethod, carFee);
            carPaymentStrategy.pay(carFee);
            parkingLot.vacateSpot(carSpot, car1);
        }
        if (bikeSpot != null) {
            // Calculate fee using the specific strategy for the vehicle
            double bikeFee = bike1.getParkingFeeStrategy().calculateFee("bike",1);
            PaymentStrategy bikePaymentStrategy =
                    getPaymentStrategy(paymentMethod, bikeFee);
            bikePaymentStrategy.pay(bikeFee);
            parkingLot.vacateSpot(bikeSpot, bike1);
        }
        scanner.close();
    }
    private static PaymentStrategy getPaymentStrategy(
            int paymentMethod, double fee) {
        switch (paymentMethod) {
            case 1:
                return new CashPaymentStrategy();
            case 2:
                return new Upi();
            default:
                System.out.println("Invalid choice! Default to Upi payment.");
                return new Upi();
        }
    }
}
