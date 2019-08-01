package ratelimit.ratelimit.hystricx;

import com.netflix.hystrix.strategy.properties.HystrixProperty;
import com.netflix.hystrix.util.HystrixRollingNumber;
import com.netflix.hystrix.util.HystrixRollingNumberEvent;

public class HystricxLimit {
    
    public static void main(String[] args) {
        HystrixProperty<Integer> timeInMilliseconds = new HystrixProperty<Integer>() {

            @Override
            public Integer get() {
                return 10;
            }
            
        };
        HystrixProperty<Integer> numberOfBuckets = new HystrixProperty<Integer>() {
            
            @Override
            public Integer get() {
                return 10;
            }
            
        };
        HystrixRollingNumber hru = new HystrixRollingNumber(timeInMilliseconds, numberOfBuckets);
        
        hru.add(HystrixRollingNumberEvent.EMIT, 10);
        
        hru.getValues(HystrixRollingNumberEvent.EMIT);
    }

}
