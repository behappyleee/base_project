package features;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadLoop {

    public static void main(String[] args) {
        // 만약 Virtual Thread 가 아닌 Platform Thread 로 많은 수의 Thread 를 생성 한다면
        // 성능 문제 및 하드웨어에 영향을 줄 수 있다

        // 만약 Virtual Thread 를 많이 생성 한다하면 적은 수의 Platform Thread 를 사용할 수 도있다!
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        IntStream.range(0, 1000).forEach((i) -> {
            executor.submit(() -> {
               // Thread 를 1초 정도 재움
               Thread.sleep(1000);
               return i;
            });
        });
    }

}
