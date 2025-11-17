package RateLimitterAdvanced;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter implements RateLimiterStrategy{
    private final long windowMillis;
    private final int maxRequests;

    private static class Counter {
        volatile long windowStart;
        final AtomicInteger count = new AtomicInteger(0);
    }
    private final ConcurrentHashMap<String, Counter> map = new ConcurrentHashMap<>();
    public FixedWindowRateLimiter(long windowMillis, int maxRequests) {
        this.windowMillis = windowMillis;
        this.maxRequests = maxRequests;
    }

    @Override
    public boolean tryAcquire(String key) {
        long now = System.currentTimeMillis();
        Counter counter = map.computeIfAbsent(key,k->{
            Counter c = new Counter();
            c.windowStart=now;
            c.count.set(0);
            return c;
        });
        synchronized (counter){
            if(now-counter.windowStart>=windowMillis){
                counter.windowStart=now;
                counter.count.set(0);
            }
            return counter.count.incrementAndGet() <= maxRequests;
        }
    }
}
