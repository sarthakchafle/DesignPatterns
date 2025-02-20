package BuilderDesignPattern.Builder;

import BuilderDesignPattern.Car.Car;

public class CarBuilderImpl implements CarBuilder {
    private String engine;
    private int wheels;
    private boolean airBags;
    private boolean sunroof;

    @Override
    public CarBuilder setEngine(String engine) {
        this.engine=engine;
        return this;
    }

    @Override
    public CarBuilder setWheels(int wheels) {
        this.wheels=wheels;
        return this;
    }

    @Override
    public CarBuilder setAirBags(boolean airBags) {
        this.airBags=airBags;
        return this;
    }

    @Override
    public CarBuilder setSunroof(boolean sunroof) {
        this.sunroof=sunroof;
        return this;
    }

    @Override
    public Car build() {
        return new Car(engine,wheels,airBags,sunroof);
    }
}
