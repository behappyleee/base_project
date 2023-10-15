public class VirtualThreadEx {

    // Java Virtual Thread 개념 학습
    public static void main(String[] args) {
        // 자바 개발자들은 약 30년 동안 서버 어플리케이션 동시성 처리를 위하여 스레드를 사용해 왔다.
        // 대표적으로는 스프링 프레임 워크는 멀티 스레드 모델을 사용하고 있으며 1개의 요청을 1개의 스레드가 처리하는 thread-per-request 방식으로 동작하고 있다.
        // 따라서 동시 요청이 많다면 스레드의 수 역시 증가해야만 이에 대응이 가능하다.

        // 하지만 기존 JDK의 스레드는 운영 체제(OS) 스레드의 Wrapper 이기 때문에 사용 가능한 스레드의 수가 하드웨어 수준보다 훨씬 적게 제한되어 있다.
        // OS 스레드는 비용이 높아 요청량에 비레하여 늘릴 수 없기 때문이다. 가질 수 있는 스레드의 양은 제한적인데 자바 스레드는 OS 스레드는 비용이 높아
        // 요청량에 비례하여 늘릴 수 없기 때문이다. 자바 스레드는 OS 스레드의 Wrapper 라서 I/O 작업을 만나면 블로킹 되기까지 한다.

        // 예를 들어 멀티 스레드 기반의 스프링 애플리케이션 서버에 요청이 들어오면 톰캣의 스레드 풀에 존재하는 스레드는 CPU 를 가지고 요청을 처리하게 됨
        // 그러다가 네트워크 요청이나 파일 쓰기 같은 I/O 작업을 만나면 CPU 를 OS 에 반환하고 실행할 수 없는 상태 Non-Runnable 가 된다.

        // 이로 인해서 진행중인 스레드의 작업은 중지되고 I/O 작업이 끝날 떄까지 대기한다. 그러다가 I/O 작업이 끝나면 남은 작업을 이어가고
        // 스레드를 스레드 풀에 반환한다.

        // 만약 전체 스레드가 모두 네트워크 지연 등에 의해 블로킹 된 상황에서 새로운 요청이 들어오면 사용 가능한 스레드가 없으므로
        // 새로운 요청은 톰캣의 내부 큐에서 대기하게 되고 사용 가능한 스레드가 스레드 풀로 반환 되면 그떄서야 요청이 실행되고 만약 요청이
        // 지나치게 오래 대기하게 되면 에러가 발생

        // 오늘날에는 외부 API 나 캐기 및 DB 등을 위해 수 많은 I/O 작업들이 필요한데, 해당 작업들마다 스레드가 잠들게 되니 비효율이 발생하게 됨
        // 이를 위하여 자바 개발자들은 여러 방안을 검토 함

        // 여러가지 방안 검토 사항
        // 1. 비동기 API 에 계속 의존
        // 2. 코루틴 (syntactic stackless coroutines)을 자바 언어에 추가
        // 3. user-mode 스레드를 나타내는 새로운 public class 를 추가

        // 그 외의 방안들
        // 하드웨어를 최대한 활용하고자 일부 개발자들은 스레드를 공유하는 방식을 사용하기도 함 대표적으로 리액티브 스택 (Reactor)
        // 기반의 Spring Webflux 가 있다. 한 스레드가 I/O 작업이 끝나기를 기다리는 (블로킹) 대신 해당 스레드를 반납하여
        // 다른 요청을 처리할 수 있도록 하는 것임 I/O 작업은 제외하고 연산을 수행하는 동안에만 스레드를 보유하기에 적은 수의 스레드로도
        // 많은 동시 요청 처리가 가능

        // 하드웨어를 최적으로 활용하지 못하는 가장 큰 이유는 OS 스레드와 자바 스레드가 1:1 대응이기 떄문임
        // 즉 자바 스레드가 실행 되는 것은 OS 스레드가 사용중임을 의미

        // 운영 체제가 많은 가상 주소 공간을 제한 된 양의 물리작 RAM 에 매핑하여 메모리가 넉넉한 것처럼 보이게 하는 것처럼
        // 자바 런타임은 많은 수의 가상 스레드를 적은 수의 OS 스레드의 매핑을 하여 스레드가 넉넉하게 보이는 것처럼 함
        // 자바는 전체 실행 주기 동안 OS 스레드를 잡아 먹지 않는 java.lang.Thread 를 도입하게 됨

        // 기존 OS 스레드와 연결하는 기존 Platform Thread (자바 런타임 에만 존재 하고 OS 스레드와는 연결 되지 않는
        // 스레드인 Virtual Thread 가 존재하게 됨

        // TODO
        // virtual thread 학습 필요 !
        // https://mangkyu.tistory.com/309
        // 학습 필요 !!!!!

        // 기존 Thread 를 생성하는 코드
        Thread t1 = new Thread(new ThreadRunnable());
        t1.start();

        Runnable runnable = new ThreadRunnable();

        // 새로운 Virtual Thread 를 생성하는 코드 (ofPlatform(), ofVirtual())
        Thread t2 = Thread.ofPlatform()
                .name("virtual_test")
                .unstarted(runnable);

        Thread t3 = Thread.ofVirtual()
                .name("virtual_test2")
                .unstarted(runnable);

        Thread.startVirtualThread(runnable);

        // 현재 Thread 가 가상 스레드인지 검사
        boolean isVirtualThread_1 = t1.isVirtual();
        System.out.println("IS VIRTUAL 1 Thread : "  + isVirtualThread_1);  // false

        boolean isVirtualThread_3 = t3.isVirtual();
        System.out.printf("IS VIRTUAL 3 Thread : " + isVirtualThread_3);    // true

    }

}

class ThreadExtends extends Thread {
    @Override
    public void run() {
        System.out.printf("This is Thread Extends Run !!!!");
    }

    public void printTest() {
        System.out.printf("This is Java Thread Print Test !");
    }
}

class ThreadRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadEx Run Test !");
    }

}




