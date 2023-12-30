package thread.cordination;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class JoinFactorialThread {

    // Thread 조정
    // 다른 스레드를 멈추고 실행할 수 있음
    // 신뢰하는 스레드가 예상 시간 안에 작업을 완료하게 만드는 방법
    // 스레드 실행을 완전히 제어해야 함 특정 작업 들을 병렬로 실행하고 처리 속도를 높여 버리면
    // 안전하고 정확하게 결과 종합이 가능, 다른 스레드는 한번 시작되면 서로 다른 스레드들과 독립적으로 실행 됨

    // ex) Thread A, Thread B 가 Thread A 에 종속적일 때 사용이 가능,
    // Thread B 에서 Thread A 의 결과 값이 필요할 때
    // 제어를 해야 함, 방법은 계속 Thread B 에서 loop 를 돌리면서 Thread A 의 작업으 끝났는 지 확인을 함
    // 하지만 이는 매우 비 효울적인 방법임, Thread B 가 loop 를 타면서
    // CPU 를 작동 시키게 되므로 Thread A 작업마저 느려질 수 있음
    // 차라리 Thread A 가 작업을 빨리 마치도록 Thread B 를 아예 잠재워버리는 것도 방법임
    // Thread B 가 잠들었다가 Thread A 가 작업을 마치면 Wake up 하여 작업을 실행
    // 해당 방법을 사용시 join 메서드를 사용

        public static void main(String[] args) {
            List<Long> inputNumbers = Arrays.asList(0L, 3435L, 342432423434324324L, 34435L, 2324L, 4656L, 23L, 2435L);

            List<FactorialThread> threads = inputNumbers.stream().map(
                    FactorialThread::new
            ).toList();
    
            // Main 스레드 다음은 계승 스레드임
            // 믿을만한 결과를 위해서 스레드를 조정하는 게 좋음
            threads.forEach(thread -> {
                // Daemon Thread 를 true 로 설정해주어야 만약 끝나지 않은 스레드들이 존재 시 그냥 끝내 버림
                thread.setDaemon(true); // Daemon 스레드를 true 로 설정

                thread.start();
                try {
                    // 각 모든 실행 한 Thread 에 join 을 붙여 줌
                    // thread.join 메서드는 스레드가 종료 되어야만 반환 이 됨
                    // 그러면 Main 스레드가 밑에 작업을 실행하기전에 모든 작업이 끝날 수 있도록 기다려 줌

                    // 하지만 join 메서드를 사용시 주의해야 할 점은 여러 스레드 들 중 너무 큰 수 or 오류 발생 시 Return 이 안 되므로
                    // 이에 대한 처리를 해주어야 함
                    // 각 작업 시간 최대 시간 같은 설정도 좋은 설정 임
                    // join 을 추가해주지 않으면 스레드가 작업이 마쳤는 지 보장 받기가 힘듦

                    // 시간 설정을 해주는게 좋음, 시간 설정을 해주지 않으면 Thread 들 중 1개가 작업이 오래 걸리는 것이 있으면 Return 이 안됨
                    // thread.join(); // join 메서드를 추가하여 계승 스레드가 작업을 마칠 때 까지 Main Thread 를 기다리게 함

                    thread.join(2000);  // 2초가 지나도 스레드가 종료가 되지 않으면 그냥 메서드가 반환

                } catch (InterruptedException e) {
                    System.out.println("[THIS IS ERROR FROM INTERRUNTED EXCEPTION ] : "
                            + e.getMessage());
                }
            });

            // Main Thread 에 해당 for 문을 실행 시 어떤 스레드가 실행 완료 되었고 어떤 스레드가 계속 작업중인지
            // 확인이 가능, factorialThread 는 목표를 향해 달려감, 해당 for 문을 실행 전 어떤 스레드가 마쳤고 어떤 스레드가
            // 마쳤는 지 확인이 불가
            for(int i=0; i<threads.size(); i++) {
                FactorialThread factorialThread = threads.get(i);
                if(factorialThread.isFinished()) {
                    System.out.println("[Factorial Thread DONE] InputNumber :  " + inputNumbers.get(i)
                            + " RESULT : " + factorialThread.getResult());
                } else {
                    System.out.println("[STILL IN PROGRESS .... ] InputNumber : "
                            + inputNumbers.get(i) + " is still in progress ...");
                }
            }
    }

    private static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult = BigInteger.ONE;

            for(long i = n; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }

    }



}
