package CabBooking;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RideService {
    private static RideService instance;
    private final DistanceStrategy distanceStrategy;
    List<Driver> drivers;
    private RideService(DistanceStrategy distanceStrategy,List<Driver> drivers){
        this.distanceStrategy=distanceStrategy;
        this.drivers=drivers;
    }
    public static RideService getInstance(DistanceStrategy distanceStrategy,List<Driver> drivers){
        if(instance==null){
            instance = new RideService(distanceStrategy,drivers);

        }
        return instance;
    }
    public Driver findNearestDriver(Location passengerLocation){
        PriorityQueue<Driver> pq = new PriorityQueue<>(Comparator.comparingDouble(d-> distanceStrategy.calculate(passengerLocation,d.getLocation())));
        for(Driver driver: drivers){
            if(driver.isAvailable()){
                pq.offer(driver);
            }
        }
        return pq.isEmpty()?null:pq.poll();
    }
}
