package CabBooking;

public class EuclideanDistanceStrategy implements DistanceStrategy{
    @Override
    public double calculate(Location loc1, Location loc2) {
        return Math.sqrt(Math.pow(loc2.x-loc1.x,2)+Math.pow(loc2.y-loc1.y,2));
    }
}
