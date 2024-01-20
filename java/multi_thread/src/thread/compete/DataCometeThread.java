package thread.compete;

public class DataCometeThread {

    // 경쟁 상태란 - 공유 리소스에 접근하는 여러 스레드가 있거나, 그 중 최소한 한 스레드가 공유 리소스를 수정하는 경우로
    // 스레드 스케줄링의 순서나 시점에 따라 결과가 달라지는 것

    public static void main(String[] args) {

        // 그냥 일반 Thread 로 실행 시 불변성이 유지되지는 않음 ... !
        // 이게 바로 데이터 경쟁임, 종종 컴파일러와 CPU 가 성능 최적화와 비 순차적으로 명령을 내림
        // 비순차적 명령어 처리는 유용한 기능임 해당 기능이 없으면 매우 느려 짐

        // 컴파일러와 CPU 가 다른 코어에서 실행되는 스레드를 인지하지 못하고 동일 변수를 읽고 특정 처리 순서에 의존
        // 그 결과 예상치 못한 잘 못된 결과가 나옴
        SharedClass sc = new SharedClass();
        Thread t1 = new Thread(() -> {
           for(int i=0; i< Integer.MAX_VALUE; i++) {
               sc.increment();
           }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i< Integer.MAX_VALUE; i++) {
                sc.checkForDateRace();
            }
        });

        t1.start();
        t2.start();
    }

    public static class SharedClass {

        // Volatile 키워드를 사용하면 데이터 경쟁이 사라 짐 !
        // 데이터 경쟁에 있어서 volatile 키워드는 순서를 보장하고 모든 경우의 데이터 경쟁을 해결 시켜 줌 !
        // 경험적으로 한 스레드에 의해 수정 된 모든 공유 변수는 synchronized block 이나 volatile 로 부터 보호 되어야 함!
        private volatile int x = 0;
        private volatile int y = 0;

        // private  int x = 0;
        // private  int y = 0;

        public void increment() {
            x++;
            y++;
        }

        public void checkForDateRace() {
            if(y > x) {
                System.out.println("y > x Race is detected");
            }
        }

    }

}
