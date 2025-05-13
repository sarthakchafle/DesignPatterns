package CabBooking;

public class Driver {
    private final String name;
    private final Location location;
    private final boolean isAvailable;

    public Driver(String name, Location location, boolean isAvailable) {
        this.name = name;
        this.location = location;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
