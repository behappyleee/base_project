import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadOrder {

    // 만약 Thread A 와 Thread B 가 실행 시
    // Thread A 가 먼저 끝날 수도 Thread B 가 먼저 끝날 수도, 혹은 쓰레드가 동시에 시작 되거나 병렬로 시작 되거나
    // 조정이 가능함

    // Thread A 마친 후 Thread B 가 작업을 시작 힛
    // Thread A 가 다 끝났는 지 확인 하기 위하 여서는  아주 단순한 방법 으로는 무한 루프를 돌리는 것이다. 계속 무한 루프를 돌리면서
    // Thread A 가 작업이 다 마쳤는 지 계속 확인 하는 것 이지만 이는 아주 비효율 적이다.
    // 이 때 사용하는 것이 join() 이다.
        
    // Thread join 을 통하여 위에 Thread 가 끝날 떄까지 기다림
    
    public static void main(String[] args) throws InterruptedException {
        // List<Long> inputNumbers = Arrays.asList(0L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566l);
        
        List<Long> inputNumbers = Arrays.asList(100000000L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566l);

        // 계승을 계산하는 것은 아주 Heavy 한 작업 임
        // 그래서 다른 Thread 에 맡김
        // We want to calcultate the factorial

        List<FactorialThread> threads = new ArrayList<>();

        
        for(long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for(Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }
            
        // Thrad Join 을 통하여 Thread 를 더 강력하게 통제가 가능함
        // Main 쓰레드 Loop 종료 될 떄 까지 모두 계승 Thread 는 작업을 마치게 됨
        
        // 믿을만한 결과를 만들기 위하여서는 늘 스레드를 조정하야여 함
        // 항상 방어적 프로그래밍을 해야함
        for(Thread thread : threads) {
           // thread.join();
            thread.join(2000);  // 모든 쓰레드의 작업이 2초를 넘치 않게 설정 함
        }

        // 동기적으로 실행 하여 계산이 짧은 쓰레드는 끝나있음
        // Thread 는 동시에 시작하였지만 끝나는 것은 작업 속도에 따라 모든 Thread 가 다름 !!!!
        for(int i=0; i<inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if(factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The Calculation for " + inputNumbers.get(i) + " is still progress");
            }
        }

    }

}
