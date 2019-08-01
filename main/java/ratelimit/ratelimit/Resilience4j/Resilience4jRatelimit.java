package ratelimit.ratelimit.Resilience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;

public class Resilience4jRatelimit {
    
    public static void main(String[] args) {
        RateLimiter rlt = RateLimiter.ofDefaults("abc");
        rlt.acquirePermission();
    }

}
