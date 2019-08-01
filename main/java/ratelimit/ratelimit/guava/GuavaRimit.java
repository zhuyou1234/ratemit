package ratelimit.ratelimit.guava;

import com.google.common.util.concurrent.RateLimiter;

public class GuavaRimit {
    
    public static void main(String[] args) {
        RateLimiter create = RateLimiter.create(10);
        create.acquire(10);
        
    }

}
