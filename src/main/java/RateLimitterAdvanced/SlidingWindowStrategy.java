package RateLimitterAdvanced;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindowStrategy implements RateLimiterStrategy{
    private final long windowMillis;
    private final int maxRequests;
    private final ConcurrentHashMap<String, ConcurrentLinkedDeque<Long>> map = new ConcurrentHashMap<>();

    public SlidingWindowStrategy(long windowMillis, int maxRequests) {
        this.windowMillis = windowMillis;
        this.maxRequests = maxRequests;
    }


    @Override
    public boolean tryAcquire(String key) {
        long now = System.currentTimeMillis();
        ConcurrentLinkedDeque<Long> dq = map.computeIfAbsent(key,k-> new ConcurrentLinkedDeque<>());
        synchronized (dq) {
            while (!dq.isEmpty() && now - windowMillis >= dq.peek()) {
                dq.pollFirst();
            }
            if (dq.size() < maxRequests) {
                dq.add(now);
                return true;
            }
            return false;
        }
    }
}
