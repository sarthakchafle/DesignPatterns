package BuilderDesignPattern;

import BuilderDesignPattern.Builder.CarBuilder;
import BuilderDesignPattern.Builder.CarBuilderImpl;
import BuilderDesignPattern.Car.Car;

public class Main {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();
        Car car = carBuilder
                .setEngine("V8 Turbo")
                .setWheels(4)
                .setAirBags(true)
                .setSunroof(true)
                .build();
        car.showCarDetails();
    }
}
