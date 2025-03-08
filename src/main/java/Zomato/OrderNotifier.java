package Zomato;

import java.util.ArrayList;
import java.util.List;

public class OrderNotifier {
    List<Observer> observers = new ArrayList<>();

    public OrderNotifier(List<Observer> observers) {
        this.observers = observers;
    }
    public void notifyUsers(String message){
        for (Observer observer:observers){
            observer.update(message);
        }
    }
}
