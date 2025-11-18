package ProducerConsumerAdvanced;

public class ProducerConsumerMain {
    public static void main(String[] args) throws InterruptedException {
        Strategy strategy = new BufferStrategy();
        strategy.start();
    }
}
