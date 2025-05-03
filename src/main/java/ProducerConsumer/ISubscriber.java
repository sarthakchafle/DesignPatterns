package ProducerConsumer;


public interface ISubscriber {
    String getId();
    void onMessage(Message message) throws InterruptedException;
}
