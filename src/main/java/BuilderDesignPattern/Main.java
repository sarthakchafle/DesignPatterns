package BuilderDesignPattern;

import BuilderDesignPattern.Builder.CarBuilderImpl;
import BuilderDesignPattern.Car.Car;

public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilderImpl()
                .setEngine("V8 Turbo")
                .setWheels(4)
                .setAirBags(true)
                .setSunroof(true)
                .build();
        car.showCarDetails();
    }
}
