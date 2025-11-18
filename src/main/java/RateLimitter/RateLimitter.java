package RateLimitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitter {
    Map<String,TokenBucket> map = new ConcurrentHashMap<>();
    int capacity;
    double refillRate;
    RateLimitter(int capacity,double refillRate){
        this.capacity=capacity;
        this.refillRate=refillRate;
    }
    public boolean isRequestAllowed(String userId){
        map.putIfAbsent(userId,new TokenBucket(capacity,refillRate));
        return map.get(userId).allowRequest();
    }
    public double getTokenCount(String userid){
        return map.get(userid).getTokenCount();
    }
}
