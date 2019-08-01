package ratelimit.ratelimit.rxjava;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import rx.Observable;
import rx.subjects.PublishSubject;

public class RxJavaLimit {

    public static void main(String[] args) throws Exception {
        final Random random = new Random();
        AtomicInteger totalCount = new AtomicInteger();
        AtomicInteger curCount = new AtomicInteger();
        
        PublishSubject<Integer> create = PublishSubject.create();
        Observable<Observable<Integer>> window = create.window(1, TimeUnit.SECONDS, 10);
        window.flatMap(t -> t.toList()).subscribe(t1 -> {
            int size = t1.size();
            totalCount.addAndGet(size);
            curCount.set(size);
        });
        create.onNext(10);
        
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                create.onNext(i + 0);
                try {
                    Thread.sleep(random.nextInt(100) + 100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        int i = 0;
        while (i < 100) {
            System.out.println("totalCount:" + totalCount.get());
            System.out.println("curCount:" + curCount.get());
            Thread.sleep(500);
        }
    }

}
