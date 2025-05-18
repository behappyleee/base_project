package templatemethod.data;

import com.sun.jdi.event.ThreadDeathEvent;

import javax.swing.text.html.Option;
import java.nio.channels.Selector;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

// CSV 데이터를 처리하는 과정을 구현
public class CSVDataProcessor extends DataProcessor {
    @Override
    protected void loadData(String data) {
        Predicate<String> aaaaa = (test) -> test.length() > 1;
        aaaaa.and((test) -> test.length() > 3);
        var aaaa = aaaaa.test("TEST");

        Predicate<String> a1 = (test) -> test.length() > 1;
        Predicate<String> a2 = (test) -> test.length() > 3;
        Predicate<String> a3 = (test) -> test.length() > 4;
        var a4 = a1.and(a2).and(a3);

        ReentrantLock lock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(1);
        lock.tryLock();
        System.out.println("Loading data from CSV ....");
    }

    @Override
    protected void processData(String data) {
        System.out.println("Processing CSV Data ...");
    }

    @Override
    protected void saveData(String data) {
        System.out.println("Saving CSV Data ....");
    }

    @Override
    protected boolean isVisibleData(String data) {
        return data != null && data.contains("CSV");
    }

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        final int COUNT = 100_000;

        for (int i = 0; i < COUNT; i++) {
            Thread thread = new Thread(() -> {});
            thread.start();
        }

        Long endTime = System.currentTimeMillis();
        System.out.println("소요 시간 NanoSeconds : " + (endTime - startTime));
    }
}
