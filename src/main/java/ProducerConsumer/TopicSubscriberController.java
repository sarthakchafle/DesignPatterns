package ProducerConsumer;

public class TopicSubscriberController implements Runnable{
    private final TopicSubscriber topicSubscriber;
    public TopicSubscriberController(TopicSubscriber topicSubscriber) {
        this.topicSubscriber = topicSubscriber;
    }
    @Override
    public void run() {
        Topic topic = topicSubscriber.getTopic();
        ISubscriber subscriber = topicSubscriber.getSubscriber();
        while (true){
            Message messageToProcess = null;
            synchronized (topicSubscriber){
                while (topicSubscriber.getOffset().get()>= topic.getMessages().size()){
                    try{
                        topicSubscriber.wait();
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                //returns a value before incrementing
                int currentOffset = topicSubscriber.getOffset().getAndIncrement();
                messageToProcess = topic.getMessages().get(currentOffset);
            }
            //process the message outside the synchronised block
            try{
                subscriber.onMessage(messageToProcess);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
