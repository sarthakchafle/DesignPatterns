package CabBooking;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CabBookingMainTest {
    private List<Driver> drivers;
    private RideService rideService;
    private DistanceStrategy distanceStrategy;

    @BeforeEach
    void setUp() throws IllegalAccessException {
        drivers = new ArrayList<>();
        drivers.add(new Driver("Alice", new Location(10, 20), true));
        drivers.add(new Driver("Bob", new Location(12, 25), true));
        drivers.add(new Driver("Charlie", new Location(5, 15), false)); // Unavailable driver
        drivers.add(new Driver("David", new Location(8, 18), true));
        drivers.add(new Driver("Abdul", new Location(0, 1), true));
        drivers.add(new Driver("Abdullah", new Location(0, 0.5), false));

        // Create Euclidean distance strategy
        distanceStrategy = DistanceStrategyFactory.getStrategy("euclidean");
        rideService = RideService.getInstance(distanceStrategy, drivers);
    }

    @Test
    void findNearestDriver() {
        Location passengerLocation = new Location(0, 0);
        Driver nearestDriver = rideService.findNearestDriver(passengerLocation);
        assertNotNull(nearestDriver, "Nearest driver should not be null");
        assertEquals("Abdul", nearestDriver.getName());
    }

    @Test
    void testNoAvailableDriver() throws IllegalAccessException {
        // Make all drivers unavailable
        for (Driver driver : drivers) {
            driver.setAvailable(false);
        }

        // Reinitialize RideService to reflect changes
        rideService = RideService.getInstance(distanceStrategy, drivers);

        Location passengerLocation = new Location(0, 0);
        Driver nearestDriver = rideService.findNearestDriver(passengerLocation);

        assertNull(nearestDriver, "No drivers should be available");
    }
    @AfterEach
    void tearDown() {
    }
}