package CabBooking;

public class DistanceStrategyFactory {
    public static DistanceStrategy getStrategy(String type) throws IllegalAccessException {
        if (type.equalsIgnoreCase("euclidean")) {
            return new EuclideanDistanceStrategy();
        } else {
            throw new IllegalAccessException("Unsupported distance type " + type);
        }
    }
}
