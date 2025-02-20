package BuilderDesignPattern.Car;

public class Car {
    private final String engine;
    private final int wheels;
    private final boolean airBags;
    private final boolean sunroof;

    public Car(String engine, int wheels, boolean airBags, boolean sunroof) {
        this.engine = engine;
        this.wheels = wheels;
        this.airBags = airBags;
        this.sunroof = sunroof;
    }
    // Method to display Car details
    public void showCarDetails() {
        System.out.println("Engine: " + engine);
        System.out.println("Wheels: " + wheels);
        System.out.println("Airbags: " + airBags);
        System.out.println("Sunroof: " + sunroof);
    }
}
