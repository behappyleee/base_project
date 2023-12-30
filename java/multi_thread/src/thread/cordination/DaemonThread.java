package thread.cordination;

import java.math.BigInteger;

public class DaemonThread {
    // Interrupt 신호에 명시적으로 반응하는 메서드를 사용하지 않을 떄 InterruptException 을 발생시켜 직접 처리를 해주어야 함
    // 앱을 Daemon 스레드로 설정 해 스레드가 앱의 종료를 방해하지 않는 방법을 배움

    // Daemon 스레드는 배경에서 실행되는 스레드로
    // 메인 스레드가 종료 되어도 어플리케이션 종료를 막지 않음
    // 몇몇 시나리오에서 Thread 를 Daemon 으로 생성을 하면 앱의 주 작업이 아닌 백그라운드 작업을 맡음

    // ex) TextEditor 에서 몇 분마다작업을 파일에 저장하는 스레드가 있음 우리는 갑자기 앱을 닫고 싶으면 백 그라운드
    // 스레드의 실행 여부는 신경 쓰지 않고 완료 될 떄 까지 기다리지도 않음

    // 2번째 시나리오는 작업자 스레드에서 실행 되는 코드를 제어할 수 없는 경우 Daemon Thread 가 앱 종료를 방해하는 일은
    // 없어야 함
    // ex) 외부 라이브러리를 호출하는 코드가 좋은 예 해당 라이브러리는 Thread 인터럽트 신호를 처리할 수 없음

    // 만약 Thread Interrupt 를 정상적으로 처리할 필요가 없으면
    // Thread 의 Daemon 속성을 true 로 설정

    public static void main(String[] args) {
        // 큰 숫자를 넣으면 계산하는 데 매우 오래 시간이 걸림
        // 계산이 끝날 떄 까지 기다리거나 Thread 를 Interrupt 하여서 앱을 종료 하여야 함
        Thread t1 = new Thread(new LongComputationTask1(
                new BigInteger("2000"),
                new BigInteger("100000000")
        ));

        // 만약 Thread Interrupt 를 정상적으로 처리할 필요가 없으면
        // Thread 의 Daemon 속성을 true 로 설정
        // true 로 설정 시 만약 큰 수의 오래 걸리는 계산이 끝나지 않았어도 main 스레드가 종료가 된 후 전체 앱이 종료 됨
        t1.setDaemon(true); // 그러면 interrupt 받는 순간 스레드가 종료 가 됨, 주로 외부 라이브러리 호출 코드나 통제 할 수 없는 코드 사용 시 사용
        t1.start();
        t1.interrupt();
        // Interrupt 를 하여도 프로그램이 끝나지는 않음 interrupt 받은 후 처리하는 코드가 없기 때문
    //     t1.interrupt();
    }

    private static class LongComputationTask1 implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask1(BigInteger base, BigInteger power) {
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
                result = result.multiply(base);
            }
            return result;
        }

    }

}
