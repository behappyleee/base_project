package thread.cordination;

public class CoordinationThread {

    // 왜 언제 스레드를 멈추어야 할까 ... ?
    // 우선 스레드는 리소스를 사용 아무것도하지않을떄도 메모리와 일부 커널 리소스를 사용
    // Thread 사 실행 중이라면 CPU 시간 뿐만 아니라 CPU 캐시 공간도 사용
    // 스레드가 어떤 식으로든 지 오작동을 하면 스레드를 중지 하여야 함
    // 최소 하나의 스레드만 실행 되고 있어도 어플리케이션이 종료되지않음 (심지어 Main 쓰로드가 멈추었어도)
    // 프로그램을 종료 전 모든 Thread 들을 실행 중지 시켜야 함

    // 각 Thread 는 Interrup 라는 객체를 가짐
    // Interrupt 사용 이유 InterruptException 발생 시켜야 할 떄
    // 두번쨰는 인터럽트를 하려는 스레드가 신호를 명시적으로 처리를 하는 경우

    public static void main(String[] args) {
        Thread t1 = new Thread(new BlockingTask());

        t1.start();
        t1.interrupt();
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            try {
                // 잘못 된 시간을 처리하는 메서드
                // sleep 메서드 InterruptException 이 발생하면 우리가 처리를 해주어야 함
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("[THIS IS INTERRUPT EXCEPTION] System Exit : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[THIS IS EXCEPTION] : " + e.getMessage());
            }
        }
    }

}
