package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadTest {
    public static void main(String[] args) {

        try(ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Submit a task that prints a message
            Future<?> future = myExecutor.submit(() -> System.out.println("Running a new Thread !"));

            // Wait for the task to complete
            future.get();

            System.out.println("Program Completed !!!");
            System.out.println("Current Thread Name : " + Thread.currentThread().getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
