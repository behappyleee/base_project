package thread.stack.heap;

import java.util.concurrent.TimeUnit;

public class SynchronizedVolatileThread {

    // Java 의 메모리 구조는 CPU-RAM 아키텍처 기반으로 이루어짐
    // CPU 가 작업을 처리하기 위해 필요한 데이터를 RAM 에서 읽어들여서 CPU Cache Memory 에 복제를 함
    // 작업을 처리한 뒤 변경 된 CPU Cache Memory 의 데이터를 RAM 에 덮어 씌움 (RAM 쓰기 작업)
    // 이떄 CPU 가 여러개일 경우, 각 CPU 별 Cache Memory 에 저장 된 데이터가 달라 문제 발생 가능성이 있음

    // 가시성 문제
    // 하나의 스레드에서 공유 자원 (변수, 객체 등) 수정한 결과가 다른 스레드에게 보이지 않는 경우 발생하는 문제

    private static volatile boolean stopRequested;  // 무조건 메인 메모리에서 데이터를 가져옴

    public static void main(String[] args) throws InterruptedException {
        Thread background = new Thread(() ->{
           for(int i=0; !stopRequested; i++) {
               System.out.println("Back Ground Thread 가 종료 되었습니다.");
           }
        });

        background.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
        System.out.println("Main Thread 가 종료 되었습니다.");
    }

}
