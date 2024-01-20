package thread.lock;

import java.util.Random;

public class DeadLockThread {

    // DeadLock Solution
    // Locking 순서를 유지하면 Deadlock 예방이 가능함
    // 데드락을 감지하는 Watchdog 을 사용, 감시 장치는 다양한 스레드로 사용이 가능

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread trainA = new Thread(new TrainA(intersection));
        Thread trainB = new Thread(new TrainB(intersection));

        trainA.start();
        trainB.start();
    }

    public static class TrainB implements Runnable {

        private Intersection intersection;
        private Random random = new Random();

        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while(true) {
                long sleepingTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepingTime);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread 가 다시 가동이 되면 기차가 철도 A 를 타고 교차로를 지나감
                intersection.takeRoadB();
            }
        }
    }


    public static class TrainA implements Runnable {

        private Intersection intersection;
        private Random random = new Random();

        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while(true) {
                long sleepingTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepingTime);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread 가 다시 가동이 되면 기차가 철도 A 를 타고 교차로를 지나감
                intersection.takeRoadA();
            }
        }
    }

    public static class Intersection {

        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA() {
            // 기차가 통과하고나면 두 철도는 사용 가능한 상태가 됨
            synchronized (roadA) {
                System.out.println("Road A is Locked By Thread : " + Thread.currentThread().getName());
                synchronized (roadB) {
                    System.out.println("Train is passing through Road A");
                    try {
                        Thread.sleep(1);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // Deadlock 을 해결하기 위하여 Synchronized 를 첫번쨰 Synchronized 를 roadA 로 바꾸어 줌
        public void takeRoadB() {
            // synchronized (roadB) {
            synchronized (roadA) {
                System.out.println("Road A is locked by Thread : " + Thread.currentThread().getName());
            //     synchronized (roadA) {
                synchronized (roadB) {
                    System.out.println("Train is Passing through Road B");
                    try {
                        Thread.sleep(1);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
