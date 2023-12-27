package thread.basic;

public class ThreadException {

    public static void main(String[] args) {

        // 보통 Java 에서 체크 되지 않은 예외는 우리가 직접 캐치해서 특정 방법으로 처리하지 않으면
        // 전체 스레드를 다운 시큼
        // 처음부터 전체 스레드에 해당 되는 예외 스레드를 지정이 가능

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("[THREAD EXCEPTION DATA CHECK]");
                // Thread 내에서 Exception 발생 시 아래 Thread Handler 작동
                throw new RuntimeException("[TEST RUNTIME EXCEPTION !!!]");
            }
        });

        thread.setName("CustomThread");

        // Thread 내에서 발생한 예외가 어디서도 캐치 되지 않으면 핸들러가 호출이 됨
        // 문제가 발생한 이후에 우리가 해결이 가능
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("[ERROR THREAD NAME] : " + t.getName());
                System.out.println("[HAPPEN CRITICAL THREAD EXCEPTION THIS IS EXCEPTION HANDLER !]");
            }
        });

        thread.start();
    }

}
