package ObserverDesignPattern;

public interface Activities {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
