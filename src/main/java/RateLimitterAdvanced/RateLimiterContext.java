package RateLimitterAdvanced;

public class RateLimiterContext{
    RateLimiterStrategy rateLimiterStrategy;

    public RateLimiterContext(RateLimiterStrategy rateLimiterStrategy) {
        this.rateLimiterStrategy = rateLimiterStrategy;
    }

    public void setRateLimiterStrategy(RateLimiterStrategy rateLimiterStrategy) {
        this.rateLimiterStrategy = rateLimiterStrategy;
    }

    public boolean tryAcquire(String key) {
        return rateLimiterStrategy.tryAcquire(key);
    }
}
