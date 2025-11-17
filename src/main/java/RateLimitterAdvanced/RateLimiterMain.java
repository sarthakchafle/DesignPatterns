package RateLimitterAdvanced;

public class RateLimiterMain {
    public static void main(String[] args) throws InterruptedException {
        RateLimiterContext context = new RateLimiterContext(new TokenBucketStrategy(2,2,800));//2 token per 0.8 sec in a 2 size bucket
        for(int i=0;i<20;i++){
            boolean ok = context.tryAcquire("213");
            System.out.println(i+": "+ok);
            Thread.sleep(80);
        }
    }
}
