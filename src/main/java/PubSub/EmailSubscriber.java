package PubSub;

public class EmailSubscriber implements Subscriber {
    String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Message message) {
        System.out.println(name + " received Email Notification: " + message.getContent());
    }
}
