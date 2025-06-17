package RateLimitter;

import lombok.AllArgsConstructor;

public class TokenBucket {
    int capacity;
    double tokens;
    long lastRefillTimestamp;
    double refillRate;

    public TokenBucket(int capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens=capacity;
        this.lastRefillTimestamp=System.nanoTime();

    }

    public synchronized boolean allowRequest(){
        refill();
        if(tokens>=1.0){
            tokens-=1.0;
            return true;
        }
        return false;
    }
    private void refill(){
        long now = System.nanoTime();
        double secondsSinceLast = (now - lastRefillTimestamp)/100000000.0;
        double tokensToAdd = secondsSinceLast * refillRate;
        if(tokensToAdd>0.0){
            tokens = Math.min(capacity,tokens+tokensToAdd);
            lastRefillTimestamp= now;
        }
    }
    public synchronized double getTokenCount(){
        return tokens;
    }
}

