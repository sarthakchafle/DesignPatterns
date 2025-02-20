package ObserverDesignPattern;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer ledDisplay = new LedDisplay();

        weatherStation.registerObserver(phoneDisplay);
        weatherStation.registerObserver(ledDisplay);
        // Change temperature and notify observers
        System.out.println("Setting temperature to 25°C...");
        weatherStation.setTemperature(25.0f);

        System.out.println("\nSetting temperature to 30°C...");
        weatherStation.setTemperature(30.0f);
    }
}
