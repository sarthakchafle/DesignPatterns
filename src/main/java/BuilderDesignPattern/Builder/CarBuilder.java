package BuilderDesignPattern.Builder;

import BuilderDesignPattern.Car.Car;

public interface CarBuilder {
    CarBuilder setEngine(String engine);
    CarBuilder setWheels(int wheels);
    CarBuilder setAirBags(boolean airBags);
    CarBuilder setSunroof(boolean sunroof);
    Car build(); // Method to return the final Car object
}
