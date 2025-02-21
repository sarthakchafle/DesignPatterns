package PubSub;

public class SmsSubscriber implements Subscriber{
    String name;

    public SmsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Message message) {
        System.out.println(name + " received Sms Notification: " + message.getContent());
    }
}
