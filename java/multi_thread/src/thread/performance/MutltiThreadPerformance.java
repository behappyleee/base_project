package thread.performance;

public class MutltiThreadPerformance {

    // 성능은 시나리와 상황애 따라 다르게 정의될 수 있음
    // 지연 시간은 시간 단위로 측정이 됨, 작업 하나의 완료 시간으로 정의가 됨
    // 처리량은 일정 시간 동안 완료한 작업의 양
    // 스레드 개수와 코어 개수가 같다는 공식은 모든 스레드가 인터럽트 없이 하위 작업을
    // 실행해야 최적임, 다시 말해 모든 스레드가 항상 Runnable 상태여야 함, IO 나 Blocking 호출도 없어야 함

    // 마지막으로 요즘 컴퓨터들은 거의 하이퍼 스레딩을 사용
    // Virtual Thread 를 사용
    public static void main(String[] args) {
        // 멀티 스레딩에서 지연 시간 줄이는 법

    }

}
