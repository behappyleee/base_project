import java.math.BigInteger;

public class Thread_Control_2 {

    public static void main(String[] args) {
        // Thread thread = new Thread(new LongComputationTask(new BigInteger("2"), new BigInteger("10")));
        // 만약 엄청나게 큰 숫자를 사용자가 입력 하는 경우
        // 계산이 끝날 때 까지 기다리거나 Thread 를 Interrupt 하여 쓰레드를 종료 하여야 함
        Thread thread = new Thread(new LongComputationTask(new BigInteger("20000"), new BigInteger("10000000")));
        thread.start();
        thread.interrupt(); // Interrupt 를 할 시 Interrupt 시 처리하여야 할 코드가 있어여 함 !
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
            System.out.println(base + " ^ " + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            // Interrupt 를 처리하기 위하여서는 Code 실행 시 오래걸리는 부분을 찾아야 함
            // 현재는 해당 for 문 Loop 에서 오래 걸림
            for(BigInteger i=BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("Permaturely interrupted computation !");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }

}
