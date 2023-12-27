package thread.basic;

public class ThreadRunnableExample {

    public static void main(String[] args) throws InterruptedException {
        // 새 스레드를 만든 후 start 메서드를 호출하여야 새로운 Thread 를 실행
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Code that will run in a new Thread !
                System.out.println("We are new Thread : " + Thread.currentThread().getName());
                // Thread 에 의미있는 이름은 Debugging 에 큰 도움을 줌
                System.out.println("Current Thread Priority : " + Thread.currentThread().getPriority());
            }
        });
        
        // Thread 객체를 얻으면 메서드 조회가 가능
        // 새로운 Thread 를 실행 전
        System.out.println("We are in Thread :  " + Thread.currentThread().getName());

        // JVM 이 새 스레드를 생성하여 운영 체제에 전달 해 줌
        // 운영체제에 의하여 비동기적으로 발생
        thread1.setName("New Worker Thread");   // Thread 에 Name 을 설정
        thread1.setPriority(Thread.MAX_PRIORITY);   // Priority 지정도 가능, Thread 수 가 많으면 중요한 역학을 해 줌
        thread1.start();

        // 새로운 Thread 실행 후
        // System.out.println("We are in Thread : " + Thread.currentThread().getName());

        // sleep 메서드는 운영체제어 전달 해 줌, 이 시간이 지날 때 까지는 스케줄링 안해 주도록
        // 이 스레드는 이 시간 동안 CPU 를 사용하지 않음
        Thread.sleep(1000);

        // 새로운 Thread 실행 후
        System.out.println("We are in Thread : " + Thread.currentThread().getName());
    }

}

