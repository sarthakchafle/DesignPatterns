package ProducerConsumerAdvanced;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable{
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try{
            int value=0;
            while(true){
                queue.put(value);
                System.out.println("Produced:" + value + " | Queue size: " + queue.size());
                value++;
                Thread.sleep(100);
            }
        }catch (InterruptedException e){

        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(true){
                int val = queue.take();
                System.out.println("Consumed: " + val + " | Queue size: " + queue.size());
                Thread.sleep(150);
            }
        }
        catch (InterruptedException e){

        }
    }
}

public class BlockingQueueStrategy implements Strategy{
    @Override
    public void start() {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(5);

        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q)).start();
    }
}
