package CabBooking;

import java.util.ArrayList;
import java.util.List;

public class CabBookingMain {
    public static void main(String[] args) throws IllegalAccessException {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Alice",new Location(10,20),true));
        drivers.add(new Driver("Bob",new Location(12,25),true));
        drivers.add(new Driver("Charlie",new Location(5,15),false));
        drivers.add(new Driver("David",new Location(8,18),true));
        drivers.add(new Driver("Abdul",new Location(0,1),true));
        drivers.add(new Driver("Abdullah",new Location(0,0.5),false));
        Location passengerLocation = new Location(0,0);

        DistanceStrategy distanceStrategy = DistanceStrategyFactory.getStrategy("euclidean");
        RideService rideService = RideService.getInstance(distanceStrategy,drivers);

        Driver nearestDriver = rideService.findNearestDriver(passengerLocation);
        if(nearestDriver!=null){
            System.out.println("Nearest driver is "+nearestDriver.getName());
        }else{
            System.out.println("No drivers available");
        }
    }
}