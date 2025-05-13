package Zomato;

import java.util.ArrayList;
import java.util.List;

public class OrderNotifier {

    private List<Observer> observers = new ArrayList<>();

    public OrderNotifier() {
        this.observers = new ArrayList<>();
    }
    public void addObser(Observer observer){
        observers.add(observer);
    }
    public void notifyUsers(String message){
        for (Observer observer:observers){
            observer.update(message);
        }
    }
}
