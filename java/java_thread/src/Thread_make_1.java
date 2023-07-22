public class Thread_make_1 {

    public static void main(String[] args) throws InterruptedException {
        // Thread 생성
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // Code that will run in  a new thread
//            }
//        });

        // Lambda 로 코드 줄일 수 있음
        Thread thread = new Thread(() -> {
            // Code that will run in a new thread.
            System.out.println("We are now in thread : " + Thread.currentThread().getName());
            System.out.println("Current Thread Priority is " + Thread.currentThread().getPriority());
        });

        thread.setName("New Worker Thread");        // Thread 이름을 설정 디버깅 하는데 도움이 됨
        thread.setPriority(Thread.MAX_PRIORITY);    // Thread Priority 설정 (최대 10)

        // Main Thread ㅂ ㅏㄴ환
        System.out.println("We are in thread : " + Thread.currentThread().getName() + " before starting a new thread");
        // Thread 실행
        thread.start();
        // 두번째 Thread 도 Main Thread 에서 Scheduling 을 하기 위하여서는 시간이 조금 걸림
        System.out.println("We are in  thread : " + Thread.currentThread().getName() + " after starting a new thread");

        //  sleep 정적 메서드 현재 스레드를 머뭄, sleep 메서드는 OS 에게 지시하기만 함
        // 이 시간 동안은 cpu 를 사용하지 않음
        Thread.sleep(1000);

    }

}
