public class Thread_make_2 {

    public static void main(String[] args) {
        // Runnable 인터페이스를 구현하는 클래스의 객체를 Thread 객체에 전달
        // Runnable 의 또 다른 객체를 만드는 대신 스레드를 확장하는 새 클래스를 만듦
        // 제네릭 스레드 객체 대신 구체적인 새 스레드 객체를 생성
        // 현재 스레드와 직접적으로 관련 된 많은 데이터와 메서드에 액세스가 가능
        Thread thread = new NewThread();
        thread.start();


    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
           //  System.out.println("Helo From : " + Thread.currentThread().getName());
            System.out.println(this.getName());         // 대신 this 도 사용이 가능
            System.out.println(this.getPriority());
        }
    }


}
