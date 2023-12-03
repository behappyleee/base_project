package features;

import java.util.function.Supplier;

public class VirtualThreadFeature {

    // 하드웨어를 최적으로 사용하지 못하는 근본적인 원인은 OS 스레드와 Java 스레드가 1:1 대응임
    // 즉, 자바 Thread 가 실행되는 것은 OS 스레드가 실행중임을 의미
    // 따라서 해결 방안은 Java Runtime 에서 OS 스레드와 일대일 대응이 되지 않도록 더 효율적인 스레드를 구성
    // 운영체제가 많은 가상 주소 공간을 제한 된 양의 물리적 RAM 에 매핑하여 메모리가 넉넉한 것처럼 보이게 하는 것처럼
    // 자바 런타임은 많은 수의 가상 Thread 를 적은 수의 OS 스레드에 맵핑하여 스레드가 넉넉한 것처럼 보이게 하는 것.
    // 자바는 전체 실행 주기 동안 OS 스레드를 잡아먹지 않는 java.lang.Thread 인스턴스를 도입하게 됨
    // 즉 java.lang.Thread 의 인스턴스로 OS 스레드와 연결 되는 기존의 스레드인 플랫폼 스레드 Platform Thread 와 자바 런타임
    // 에만 존재하고 OS 스레드와는 연결 되지 않는 신규 스레드인 Virtual Thread 가 존재하게 됨

    // 가상 스레드는 OS 가 아닌 JDK 에서 제공하는 경량화 된 user-mode Thread 이다. 특정 OS 스레드에 연결되지 않으므로
    // OS 에서는 보이지 않으며 존재를 인식하지 못함

    // Virtual Thread
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("[Virtual Thread Run Test !!!]");
            }
        };

        Thread t1 = Thread.ofPlatform()
                .name("[VIRTUAL TEST 1]")
                .unstarted(runnable);

        Thread t2 = Thread.ofVirtual()
                .name("[VIRTUAL THREAD 22]")
                .unstarted(runnable);

        Thread.startVirtualThread(runnable);

        System.out.println("[T1 IS VIRTUAL ] : "  + t1.isVirtual());    // false
        System.out.println("[T2 IS VIRTUAL ] : "  + t2.isVirtual());    // true

    }

}



