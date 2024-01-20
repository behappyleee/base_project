package thread.lock;

import java.util.Random;

public class DeadLockThreadSolution {

    public static void main(String[] args) {
        // 공유리 소스를 개별 리소스로 잠금
        // 여러 개의 개별 락킹 시 가장 큰 문제는 데드락임
        // DeadLock - 모두가 움직이려고 하지만 다른 사람의 움직임을 기다리느라 움직이지 못하는 상태

        // ex) Thread1 과 Thread2 가 있음 Thread1 이 lock(A) 를 한 상태 Thread2 lock(B) 를 한 후 lock(A)
        // 를 함 하지만 Thread1 이 lock1(A) 를 풀지 않으면 Thread2 lock(A) 를 할 수가 없음
        // 현재 상태에서 Thread1 이 lock(B) 를 해버림 --->> 해당 사항이 DeadLock 임

        // 해당 상태가 되면서 DeadLock 이 발생함
        // Road A is Locked By Thread : Thread-0
        // Road B is locked by Thread : Thread-1

        // 철도 A 는 Thread A 에 의하여 잠기고
        // 철도 B 는 Thread B 에 의하여 잠겨 Deadlock 이 발생함

        // Deadlock 발생 조건
        // 1) 상호 배제 - 즉 한번에 한 스레드만 단독으로 리소스에 접근이 가능
        // 2) 점유와 대기 - 최소 하나의 스레드가 리소스를 점유하며 다른 리소스에 대기함
        // 하나가 아닌 두개의 스레드가 철도 하나를 점유하며 다른 철도를 기다림
        // 3) 비 선점 할당 - 스레드가 사용 완료할 때 까지 리소스를 사용할 수 없는 것, 다시 말해 다른 스레드의
        // 리소스를 뻇을 수 없다는 뜻, 해당 스레드의 리소스 사용이 끝날 때 까지 기다려야 함
        // 4) 순환 대기 -

        // Deadlock 해결에 가장 확실한 솔루션은 4가지 조건 중 아무것도 속하지 않게 하는 것임

        DeadLockThread.Intersection intersection = new DeadLockThread.Intersection();
        Thread trainA = new Thread(new DeadLockThread.TrainA(intersection));
        Thread trainB = new Thread(new DeadLockThread.TrainB(intersection));

        trainA.start();
        trainB.start();

    }

    public static class TrainB implements Runnable {

        private DeadLockThread.Intersection intersection;
        private Random random = new Random();

        public TrainB(DeadLockThread.Intersection intersection) {
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

        private DeadLockThread.Intersection intersection;
        private Random random = new Random();

        public TrainA(DeadLockThread.Intersection intersection) {
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

        public void takeRoadB() {
            synchronized (roadB) {
                System.out.println("Road B is locked by Thread : " + Thread.currentThread().getName());
                synchronized (roadA) {
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
