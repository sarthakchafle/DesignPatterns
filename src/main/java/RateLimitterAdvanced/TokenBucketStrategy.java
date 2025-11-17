package RateLimitterAdvanced;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketStrategy implements RateLimiterStrategy{
    public static class Bucket{
        final double capacity;
        final double refillTokenPerMillis;
        double tokens;
        long lastRefill;

        public Bucket(double capacity, double refillTokenPerMillis, long now) {
            this.capacity = capacity;
            this.refillTokenPerMillis = refillTokenPerMillis;
            this.lastRefill = now;
            this.tokens = capacity;
        }
    }
    private final ConcurrentHashMap<String,Bucket> map = new ConcurrentHashMap<>();
    private final double capacity;
    private final double refillTokensPerWindow;
    private final long windowMillis;

    public TokenBucketStrategy(double capacity, double refillTokensPerWindow, long windowMillis) {
        this.capacity = capacity;
        this.refillTokensPerWindow = refillTokensPerWindow;
        this.windowMillis = windowMillis;
    }

    @Override
    public boolean tryAcquire(String key) {
        long now = System.currentTimeMillis();
        Bucket bucket = map.computeIfAbsent(key,k-> new Bucket(capacity,refillTokensPerWindow/(double) windowMillis, now));
        synchronized (bucket){
            double delta = (now - bucket.lastRefill)*bucket.refillTokenPerMillis;
            System.out.println("tokens: "+bucket.tokens);
            if(delta>0){
                bucket.tokens = Math.min(bucket.capacity,bucket.tokens+delta);
                bucket.lastRefill=now;
            }
            if(bucket.tokens>=1.0){
                bucket.tokens-=1.0;
                return true;
            }else{
                return false;
            }
        }
    }
}
