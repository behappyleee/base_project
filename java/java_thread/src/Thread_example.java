import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Thread_example {

    public static final int MAX_PASSWORD = 9999;    // 비밀번호 최대 정수 값 정의 MAX PASSWORD 설정

    public static void main(String[] args) {
        // 도둑 3명이 금고를 훔치고 경찰이 쫓아옴 경찰이 10초 동안 쫓아오는 것을 상황으로 보여 줌
        // 실행 마다 임의의 패스워드를 생성
        Random random = new Random();
        int randomPassword = random.nextInt(MAX_PASSWORD);

        System.out.println("GET RANDOM PASSWORD : " + randomPassword);

        // Bound 로 MAX_PASSWORD 설정
        Vault vault = new Vault(randomPassword);
        
        // Thread 객체 목록도 만듦
        // 모두 타입이 Thread 이기에 구체적인 타입 상관 없으 전부 Thread 로 취급이 됨 !
        // 이를 다형성 또는 객체지향 프로그래밍이라고 함
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());
        
        // 모든 Thread 실행
        for(Thread thread : threads) {
            thread.start();
        }
    }

    private static class Vault {
        private int password;
        public Vault(int password) {
            this.password = password;
        }
        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(5);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            return this.password == guess;
        }
    }

    // 제네릭 해커 스레드 생성
    private static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);  // 우선순위 최대로 설정
        }

        // Thread 클래스를 확장 하니 Thread Class 도 Overriding 가능
        @Override
        public void start() {
            // Thread Start 메세지 출력
            System.out.println("Starting Thread : " + this.getName());
            super.start();  // 그대로 Thread Class 의 start 를 사용
        }
    }

    // 모든 기능 상속한 해커 Thread
    // 이 스레드는 모든 숫자를 오름 차순으로 평가를 하고 모든 해커 스레드와 스레드 기능을 가져옴
    private static class AscendingHackerThread extends HackerThread {
        public AscendingHackerThread (Vault vault) {
            super(vault);
        }

        // Run 메서드 override
        @Override
        public void run() {
            for(int guess = 0; guess <MAX_PASSWORD; guess++) {
                if(vault.isCorrectPassword(guess)) {
                    // Password 가 맞다면 설정 된 Thread 이름을 출력 후 프로그램을 멈춤
                    System.out.println(this.getName() + " guessed the password " + guess);
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
            for(int guess = MAX_PASSWORD; guess > 0; guess--) {
                // 비밀번호 추측 시 프로그램 실행을 멈춤
                if(vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " This Thread GUESS : " + guess);
                    System.exit(0);
                }
            }
        }
    }
    
    // 경찰 클래스
    private static class PoliceThread extends Thread {
        // Thread 를 직접 상속 하므로 Hacker Thread 에 캡슐화가 된 것은 직접 가져오지 못함
        @Override
        public void run() {
            for(int i=10; i>0; i--) {
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            System.out.println("Game Over !");
            System.exit(0);
        }
    }

}
