package thread.basic;

public class ThreadRunnable {

    public static void main(String[] args) {
    
        // Runnable 을 사용 하여 Thread 를 구현 시 Runnable 생성 객체를 파라미터로 전달시켜주어야 함
        // 하지만 Thread Class 를 생성하여 사용 하면 Runnable 인터페이스 객체를 생성하여 전달해주지 않아도 괜찮음
//        Thread threadRunnable = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("[THIS IS THREAD RUNNABLE CLASS CHECK !]");
//            }
//        });
        
        // Generic Thread 생성 대신 Thread 객체를 생성
        // Thread 2개를 생성
        NewThread nt = new NewThread();
        nt.start();
        
        NewThread nt1 = new NewThread();
        nt1.start();

    }

    // Runnable Interface 를 구현 하지 않고 바로 Thread 를 상속
    private static class NewThread extends Thread {
        // 현재 스레드와 직접적으로 관련 된 많은 데이터와 메서드에 액세스가 가능
        @Override
        public void run() {
            System.out.println("THIS GET NAME : " + this.getName());
            System.out.println("[CURRENT THREAD ID DATA CHECK ] : " + Thread.currentThread().threadId());
            System.out.println("Hello From NEW THREAD FROM : " + Thread.currentThread().getName());
        }
    }

}
