public class VirtualThreadEx {

    // Java Virtual Thread 개념 학습
    public static void main(String[] args) {
        // 자바 개발자들은 약 30년 동안 서버 어플리케이션 동시성 처리를 위하여 스레드를 사용해 왔다.
        // 대표적으로는 스프링 프레임 워크는 멀티 스레드 모델을 사용하고 있으며 1개의 요청을 1개의 스레드가 처리하는 thread-per-request 방식으로 동작하고 있다.
        // 따라서 동시 요청이 많다면 스레드의 수 역시 증가해야만 이에 대응이 가능하다.

        // 하지만 기존 JDK의 스레드는 운영 체제(OS) 스레드의 Wrapper 이기 때문에 사용 가능한 스레드의 수가 하드웨어 수준보다 훨씬 적게 제한되어 있다.
        // OS 스레드는 비용이 높아 요청량에 비레하여 늘릴 수 없기 때문이다. 가질 수 있는 스레드의 양은 제한적인데 자바 스레드는 OS 스레드는 비용이 높아
        // 요청량에 비례하여 늘릴 수 없기 때문이다. 자바 스레드는 OS 스레드의 Wrapper 라서 I/O 작업을 만나면 블로킹 되기까지 한다.

        // TODO
        // virtual thread 학습 필요 !
        // https://mangkyu.tistory.com/309
        // 학습 필요 !!!!!


    }

}
