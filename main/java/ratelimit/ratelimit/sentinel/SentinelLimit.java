package ratelimit.ratelimit.sentinel;

public class SentinelLimit {

    public static void main(String[] args) {
        RequestLimiter rl = new RequestLimiter(10);
        rl.canPass();
    }
}
