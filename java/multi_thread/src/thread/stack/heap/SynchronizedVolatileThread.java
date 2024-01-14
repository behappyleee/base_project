package thread.stack.heap;

import java.util.concurrent.TimeUnit;

public class SynchronizedVolatileThread {

    // Java 의 메모리 구조는 CPU-RAM 아키텍처 기반으로 이루어짐
    // CPU 가 작업을 처리하기 위해 필요한 데이터를 RAM 에서 읽어들여서 CPU Cache Memory 에 복제를 함
    // 작업을 처리한 뒤 변경 된 CPU Cache Memory 의 데이터를 RAM 에 덮어 씌움 (RAM 쓰기 작업)
    // 이떄 CPU 가 여러개일 경우, 각 CPU 별 Cache Memory 에 저장 된 데이터가 달라 문제 발생 가능성이 있음

    // 가시성 문제
    // 하나의 스레드에서 공유 자원 (변수, 객체 등) 수정한 결과가 다른 스레드에게 보이지 않는 경우 발생하는 문제

    // Volatile 키워드 변수를 오직 Main Memory 에만 저장 하겠다는 뜻을 가진 키워드 !
    // Volatile 키워드를 붙인 자원은 read 나 write 작업이 CPU Cache Memory 가 아닌 Main Memory 에서 이루어 진다.
    // Volatile 은 하나의 Thread 만이 write 를 하고 나머지 thread 는 read 를 한다는 전제 하게 비동기 이슈를 해결하게 됨
    // Volatile 키워드를 사용하면 자원을 저장하는 메모리는 하나가 된다 ! 즉 같은 공유 자원에 대해 각 메모리 별로 다른 값을 가지는 경우는 없게 됨
    // 하지만 여러 쓰레드에서 Main Memory 에 있는 공유 자원에 동시에 접근 할 수는 있다. 따라서 동시에 접근하여 여러 쓰레드에서 수정이 발생할 경우
    // 기존 동시접근 문제처럼 연산이 느린 쓰레드의 계산 값으로 덮어 씌워질 수 있기 떄문 이다 ... ! 요약하면 Volatile 키워드로 가시성 문제는 해결이 가능하지만
    // 동시접근 문제는 해결할 수 가 없다 !
    private static volatile boolean stopRequested;  // 무조건 메인 메모리에서 데이터를 가져옴

    private static volatile int t;

    public static void main(String[] args) throws InterruptedException {

        // volatileKeyWordTest();

        ThreadTest();
    }

    public static void volatileKeyWordTest() throws InterruptedException{
        // 예상은 (A) 이후 (B) 가 실행되지 전까지 i 에 1씩 더하다가
        // (B) 가 실행 된 이후 (약 1초 후)에는 while 문을 빠져나오고 프로그램이 종료될 것 처럼 보이지만
        // 정작 코드를 실행시켜보면 몇분이 지나도 프로그램은 종료되지 않는다.

        // 바로 가시성 문제때문이다.
        // Background Thread 는 Main Thread 와 다른 CPU 의 캐시 메모리에 메인 메모리에 존재하는 stopRequested 공유자원을 복제
        // 이후, (N) 의 조건식과 증감식을 반복하여 실행 함, 1초 이후 Main Thread 에서 stopRequested 를 true 로 바꾼다.
        // 하지만 background Thread 에서는 Main Thread 와 다른 CPU Cache Memory 에 있는 stopRequested 르 참조하기 떄문에
        // Main Thread 에서 일어난 변경을 알아채지 못한다.

        // 이렇듯 공유 자원을 CPU Cache Memory 에서 복제 해서 사용하기 때문에 타 스레드 에서의 변경을 알아차리지 못하는 것이다.
        Thread background = new Thread(() ->{
            for(int i=0; !stopRequested; i++) {
                System.out.println("Back Ground Thread 가 종료 되었습니다.");
            }
        });

        background.start(); // (A)

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true; // (B)
        System.out.println("Main Thread 가 종료 되었습니다.");
    }

    public static void ThreadTest () {
        // 코드를 보면 1 부터 10000 까지 출력할 것 같지만
        // 하지만 코드를 실행 시켜 보면 99995, 999997 같으 10만 언저리에서 프로그램이 종료를 하게 된다.

        // 하지만 코드를 실행시켜보면 10만 언저리에서 프로그램이 종료하게 되는데 또한 같은 숫자가 2번이 상 반복되어 출력되기도 한다.
        // 동시 접근 문제가 발생을 한다. 여러 쓰레드 (현재 100 개) 에서 공유자원에 동시에 접근하기 때문에 연산 속도가 빠른 쓰레드에서의
        // 변경 없이 연산 속도가 느린 쓰레드 에서의 변경 값으로 덮어 씌워지는 것이다.

        // 해당 연산에서 동시 접근 이슈가 발생하는 이유는 A 쓰레드의 명령어 수행이 되고 있는 도중 B 쓰레드의 명령어 수행이 되었기 때문
        
        // 하지만 만약 CPU 가 수행하는 명령이 i 에 1을 더한다가 하나였다면 ... ?!
        // 하나의 명령이 수행 되고 있는 와중, 다른 쓰레드의 명령이 실행되지 않는 다면 이러한 특성을 원자성 (하나의 명령어 
        // 수행 되는 동안 다른 쓰레드의 명령이 보류 되는 특성) 이라고 하고 이를 통해
        // 동시 접근 문제를 해결할 수 있다.
        // Java 에서는 이러한 공유 자원에 대한 비동기 이슈를 해결할 방법들을 제공
        
        // 1. Synchronized
        // Synchronized 키워드를 붙인 자원은 동시에 접근이 불가, 만약 여러 Thread 에서 해당 자원에 동시 접근 할 경우 가장 처음 접근한
        // Thread 가 작업을 끝낼 때 까지 자원에 lock 을 걸어서, 다른 Thread 에서의 접근을 완전 히 차단. 해당 Keyword 로 가시성 문제를 해결이 가능
        // Synchronized 사용 방법은 synchronized 키워드와 synchronized 블록 사용 2가지 방법이 있음

        // Synchronized 키워드를 남용할 경우 lock 이 걸리는 쓰레드들이 많아지고 synchronized 메서드 혹은 로직에 대한 병목현상 이 발생하기 쉬워
        // 아래에 나오는 volatile 이나 Atomic 을 주로 사용하는 추세

        for(int i=0; i<100; i++) {
            new Thread(() -> {
               for(int j=0; j<1000; j++) {
                   System.out.println(t++);
                   System.out.println("[PRINT T TEST CHECK ] :  " + t);
               }
            }).start();
        }
    }



}
