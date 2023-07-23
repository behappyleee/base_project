public class ThradExceptionTest {

    public static void main(String[] args){
        // Java 에서 체크되지 않은 예외는 특정 방법으로 처리하지 않으면 모든 Thread 가 죽어 버림

        // Thread 에서 실제로 수행하여야 할 Runnable 객체를 파라미터로 넘겨준다.
        Thread thread = new Thread(() -> {
            // Code that will run in a new Thrad
            // 고의적으로 Error 발생
            throw new RuntimeException("Intentional Exception !!");
        });

        thread.setName("Misbehaving Thread !!");

        // 문제가 발생한 이후에 우리가 처리가 가능, 생성 된 Threda 에서 Exception 발생 시 Handling 이 가능
        thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.println("A critical error happened in thread : "
                    + t.getName() + "The Error is " + e.getMessage());
        });

        thread.start();
    }

}
