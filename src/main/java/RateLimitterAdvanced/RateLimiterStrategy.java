package RateLimitterAdvanced;

public interface RateLimiterStrategy {
    boolean tryAcquire(String key);
}
