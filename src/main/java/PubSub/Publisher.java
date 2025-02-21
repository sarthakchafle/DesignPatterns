package PubSub;

public interface Publisher {
    void publish(String topic, Message message);
}
