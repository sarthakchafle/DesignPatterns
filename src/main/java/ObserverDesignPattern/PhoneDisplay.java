package ObserverDesignPattern;

public class PhoneDisplay implements Observer{
    private float temperature;
    @Override
    public void update(float temperature) {
        this.temperature=temperature;
        display();
    }
    public void display() {
        System.out.println("Phone Display - Current Temperature: " + temperature + "°C");
    }
}
