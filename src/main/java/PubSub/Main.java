package PubSub;

public class Main {
    public static void main(String[] args) {
        MessageBroker messageBroker = new MessageBroker();

        Publisher newsPublisher = new NewsPublisher(messageBroker);

        Subscriber emailSubscriber = new EmailSubscriber("Alice");
        Subscriber smsSubscriber = new SmsSubscriber("Bob");

        messageBroker.subscribe("Sports", emailSubscriber);
        messageBroker.subscribe("News", smsSubscriber);

        newsPublisher.publish("Sports", new Message("Sports Update: Team A won the match!"));
        newsPublisher.publish("News", new Message("Breaking News: Stock Market is up!"));
    }
}
