package ProducerConsumerAdvanced;

public class BufferStrategy implements Strategy{
    private int value = 0;
    private boolean hasValue = false;

    public synchronized void produce() throws InterruptedException {
        while (hasValue)  wait();      // wait if value already produced
        value++;
        System.out.println("Produced: " + value);
        hasValue = true;
        Thread.sleep(100);
        notify();                      // wake consumer
    }

    public synchronized void consume() throws InterruptedException {
        while (!hasValue) wait();      // wait if no value yet
        System.out.println("Consumed: " + value);
        hasValue = false;
        Thread.sleep(150);
        notify();                      // wake producer
    }

    @Override
    public void start() throws InterruptedException {
        BufferStrategy buffer = new BufferStrategy();

        new Thread(() -> {
            try {
                while (true) buffer.produce();
            } catch (Exception ignored) {}
        }).start();

        new Thread(() -> {
            try {
                while (true) buffer.consume();
            } catch (Exception ignored) {}
        }).start();
    }
}