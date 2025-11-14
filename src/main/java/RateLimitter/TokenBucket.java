package RateLimitter;

import lombok.AllArgsConstructor;

public class TokenBucket {
    int capacity;
    int tokens;
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
        if(tokens>=1){
            tokens-=1; 
            return true;
        }
        return false;
    }
    private void refill(){
        long now = System.nanoTime();
        int secondsSinceLast = (int) ((now - lastRefillTimestamp)/100000000.0);
        int tokensToAdd = (int) (secondsSinceLast * refillRate);
        if(tokensToAdd>0){
            tokens = Math.min(capacity,tokens+tokensToAdd);
            lastRefillTimestamp= now;
        }
    }
    public synchronized double getTokenCount(){
        return tokens;
    }
}

