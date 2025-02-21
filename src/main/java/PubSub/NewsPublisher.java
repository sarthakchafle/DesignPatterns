package PubSub;

public class NewsPublisher implements Publisher{
    private MessageBroker messageBroker;

    public NewsPublisher(MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public void publish(String topic, Message message) {
        System.out.println("Publishing message: " + message.getContent() + " on topic: " + topic);
        messageBroker.notifySubscribers(topic,message);
    }
}
