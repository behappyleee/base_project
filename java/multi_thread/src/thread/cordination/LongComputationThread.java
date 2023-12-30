package thread.cordination;

import java.math.BigInteger;

public class LongComputationThread {

    public static void main(String[] args) {
        // 큰 숫자를 넣으면 계산하는 데 매우 오래 시간이 걸림
        // 계산이 끝날 떄 까지 기다리거나 Thread 를 Interrupt 하여서 앱을 종료 하여야 함
        Thread t1 = new Thread(new LongComputationTask(
                new BigInteger("2000"),
                new BigInteger("10")
        ));

        t1.start();
        // Interrupt 를 하여도 프로그램이 끝나지는 않음 interrupt 받은 후 처리하는 코드가 없기 때문
        t1.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println("[LongComputationTask TASK] START !");
            System.out.println(base + " ^ " + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            // 코드 내에서 시간이 오래걸리는 곳을 찾아야 함
            // 이 스레드가 외부에서 인터럽트를 당하였는 지 확인하는 코드를 넣어 줌
            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                // 실행이 오래걸리는 곳을 찾아 Thread 가 Interrupted 당하였을 시 함수를 종료
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("[LongComputationTask Task Interrupted !]");
                    return BigInteger.ZERO;
                }

                result = result.multiply(base);
            }
            return result;
        }

    }

}


