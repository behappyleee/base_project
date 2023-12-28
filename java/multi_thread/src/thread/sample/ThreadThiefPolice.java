package thread.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadThiefPolice {

    public static final int MAX_PASSWORD = 9999;

    // 도둑 3명이 금고를 터는 중 경찰이 출동 하는 Thread
    public static void main(String[] args) {
        Random random = new Random();
        int randomNum = random.nextInt(MAX_PASSWORD);

        System.out.println("MAX INT DATA CHECK : " + randomNum);

        Vault vault = new Vault(randomNum);

        // Thread List 을 생성
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerClass(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());
        
        // Thread 들을 실행
        threads.stream().forEach(Thread::start);
    }

    private static class Vault {
        private int password;

        private Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) {
            try {
                // 속도를 늦춰줌
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            return this.password == guess;
        }
    }

        private static abstract class HackerThread extends Thread {
            protected Vault vault;

            public HackerThread(Vault vault) {
                this.vault = vault;
                this.setName(this.getClass().getSimpleName());
                this.setPriority(Thread.MAX_PRIORITY);
            }

            @Override
            public void start() {
                System.out.println("STARTING THREAD " + this.getName());
                super.start();
            }
        }

        private static class AscendingHackerClass extends HackerThread {
            public AscendingHackerClass(Vault vault) {
                super(vault);
            }

            @Override
            public void run() {
                for(int guess = 0; guess < MAX_PASSWORD; guess++) {
                    if(vault.isCorrectPassword(guess)) {
                        System.out.println("AscendingHackerClass : " +
                                Thread.currentThread().getName() + " GUESS PASSWORD : " + guess);
                        System.exit(0);
                    }
                }
            }
        }

        private static class DescendingHackerThread extends HackerThread {

            public DescendingHackerThread(Vault vault) {
                super(vault);
            }

            @Override
            public void run() {
                for(int guess = MAX_PASSWORD; guess >= 0; guess--) {
                    if(vault.isCorrectPassword(guess)) {
                        System.out.println("DescendingHackerThread : " + Thread.currentThread().getName()
                                + " PASSWORD GUESSED : " + guess);
                        System.exit(0);
                    }
                }
            }
        }

        private static class PoliceThread extends Thread {
            @Override
            public void run() {
                for(int i=10; i>0; i--) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    System.out.println("REMAIN COUNT TOTAL COUNT 10 : " + i);
                }
                // 10 초가 지나면 게임이 종료
                System.out.println("Game Over for you hackers");
                System.exit(0);
            }
        }


}
