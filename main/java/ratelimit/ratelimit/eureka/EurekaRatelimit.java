package ratelimit.ratelimit.eureka;

import java.util.concurrent.TimeUnit;

import com.netflix.discovery.util.RateLimiter;

public class EurekaRatelimit {

    public static void main(String[] args) {
        RateLimiter rl = new RateLimiter(TimeUnit.SECONDS);
        rl.acquire(10, 10);
    }

}
