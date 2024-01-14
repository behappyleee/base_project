package thread.stack.heap;

import java.nio.file.FileSystemNotFoundException;
import java.util.Random;

public class VolatileThread {

    // Volatile - 어떤 작업이 원자적 / 비원자적인지 확인 필요
    // 동기화를 최소화하기 위하여 노력하여야 함 -> 비원자적 연산이 필요
    // Volatile 키워드로 long 이나 double 변수를 선언하면 해당 변수에 읽고 쓰는 작업이
    // 스레드 안전성을 지닌 원자적 연산이 됨

    // 원자적 연산
    public static void main(String[] args) {
        Metrics metrics = new Metrics();

        BusinessLogic businessLogic = new BusinessLogic(metrics);
        BusinessLogic businessLogic1 = new BusinessLogic(metrics);

        MetricsPrinter printer = new MetricsPrinter(metrics);

        businessLogic.start();
        businessLogic1.start();
        printer.start();

    }

    public static class MetricsPrinter extends Thread {

        private Metrics metrics;

        public MetricsPrinter(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                double currentAverage = metrics.getAverage();
                System.out.println("Current Average : " + currentAverage);

            }
        }


    }

    public static class BusinessLogic extends Thread {

        private Metrics metrics;
        private Random random = new Random();

        public BusinessLogic(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long end = System.currentTimeMillis();

                metrics.addSample(end - start);
            }
        }
    }

    public static class Metrics {

        private long count = 0;
        // double 은 읽거나 쓰는게 안전하지는 앟음
        private volatile double average = 0.0;

        // 많은 Thread 가 해당 Metrics 객체에 샘플을 추가할 수 있음
        // addSample 이 원자적 연산이 아니라는 걸 쉽게 알 수 있음, 이 메서드 앞에 synchronized 키워드를 추가해
        // 동시 실행으로부터 보호를 함
        public synchronized void addSample(long sample) {
            double currentSum = average * count;
            count++;
            average = (currentSum + sample) / count;
        }

        public double getAverage() {
            return average;
        }
    }


}
