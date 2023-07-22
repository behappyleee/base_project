public class Thread_Control {
    public static void main(String[] args) {
        // Thread 조정
        // 하나의 스레드를 다른 스레드에서 멈추게 하는 작업
        // Interrupt Method, Daemon Thread
        // 스레드는 리소스를 사용 아무 것도 하지 않을 떄에도 메모리와 일부 커널 리소스를 사용
        // 스레드가 실행 중이라면 CPU 캐시도 낭비, ==> 쓰레드 정리 필요, 
        // Thread 오류시 Thread 중지 필요,
        // 또한 전체 프로그램을 종료를 해야할 떄, Thread 가 단 한개라도 실행 중 이면 애플리케이션은 종료 되지 가 않음

        Thread thread = new Thread(new BlockingTask());

        thread.start();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                // Interrupted 가 발생하면 Error Handling 이 필요
                Thread.sleep(500000);
            } catch(InterruptedException e) {
                System.out.println("Exting blocking Thread !!");
            }
        }

    }


}
