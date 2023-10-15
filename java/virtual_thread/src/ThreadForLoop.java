public class ThreadForLoop {

    public static void main(String[] args) {

        System.out.printf("[Current Thread Name] " + Thread.currentThread().getName());

        Thread[] thread = new Thread[5];

        for(int i=0; i<thread.length; i++) {
            // Thread 인스턴스 5개를 생성
            // Runnable 인스턴스를 주입
            thread[i] = new Thread(() -> {
                System.out.println("[This is Thread Name] " + Thread.currentThread().getName());
            });

            // run() 은 단순히 메서드를 실행하고 끝이고
            // start() 는 native 함수인 start0() 을 사용하여 멀티 스레드 환경을 생성 한 뒤
            // run() 메서드를 호출 한다. 즉 Thread 클래스를 제대로 활용하려면
            // run() 이 아니라 start() 를 호출해야 한다.

            // run() -> 싱글 스레드 / 단순 메서드 호출 / 메인 스레드 stack 영역 차지, 끝나기 전까지 다른 메서드 호출 불가
            // start() -> 멀티 스레드 / 네이티브 메서드 호출 / 새로운 스레드를 생성 한 뒤 stack 영역 차지 / 독립적으로 동작 가능

            // Thread.start() 는 멀티 쓰레드로 실행이 됨 (Thread 인스턴스 5개가 출력)
            thread[i].start();

            // Thread.run() 은 싱글 쓰레드로 동작이 됨 (멀티 쓰레드가 아닌 싱글 쓰레드로 작동함)
            // thread[i].run();

        }

    }

}
