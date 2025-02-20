package ObserverDesignPattern;

public class LedDisplay implements Observer{
    private float temperature;
    @Override
    public void update(float temperature) {
        this.temperature=temperature;
        display();
    }
    public void display() {
        System.out.println("LED Display - Current Temperature: " + temperature + "°C");
    }
}
