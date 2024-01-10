package thread.stack.heap;

public class StackHeapThread {

    // Stack Memory Region
    // Stack Memory - 스택은 메서드가 실행되는 메모리 영역, 함수에 인수를 입력할 때마다 스택에 입력 되고
    // 모든 로컬 변수 또한 스택에 저장 됨, 주어진 모든 순간에 각 스레드가 다른 코드라 인 또는 메서드를 실행할 수 있기에
    // 스택과 명령어 포인트러를 스레드가 실행할 때 마다 전체적인 상태를 알려주는 것임

    // Heap Memory Region

    public static void main(String[] args) {
        // 각 처리는 최소 하나의 스레드 즉, Main Thread 로 부터 시작이 됨
        // Thread 가 메서드에 들어가면 독바로 스택 위로 공간을 메서드에 맞게
        // 할당하는 데 이 공간을 Stack Frame 이라고 부름 메서드 인수는 메서드 프레임에 있는
        // Stack 에 Push 가 됨, 스택에는 모든 단일 로컬 변수가 할당이 됨, 변수는 출현 순서대로 푸시가 됨
        // 다른 메서드가 호출이 되면 새로운 Stack Frame 이 Stack 상단에 할당이 됨
        // 메섣에 입력해야하는 인수또한 Stack 에 Push 가 됨, 각 메서드는 본임 프레임의 변수에만 값을 가짐
        // 모든 메서드 프레임은 할당이 됨, 후입 선출 순서임

        // Stack 에 입력된 모든 변수는 특정 스레드에 속하기에 다른 스레드는 변수에 접근이 불가함
        // 스레드가 생성될 때 스택은 정적으로 할당이 되기 때문에 고정 된 크기를 갖고 런타임을 변경할 수 없음
        // 또한 너무 많은 메 서드 호출을 중첩하지 않도록 조심해야 함, 호층 계층 구조가 너무 길면 StackOverflow 에러 발생가능성이 있음
        // 특히 재귀 함수를 조심

        // Stack - 메서드가 호출 시 마다 모든 변수값을 저장
        // Heap - 힙은 처리에 속하는 공유 메모리 영역으로 모든 스레드가 힙에 있는 모든 데이터를 공유하고 언제나
        // 힙에 객채를 할당 하거나 그 객체에 접근할 수 가 있음, 모든 객체는 힙에 저장 됨
        // 새로운 연산자를 사용해 할당할 수 있는 객체는 전부 포함이 됨, 이런 객체로 Java 내장 클래스, 문자열, 객체
        // 컬렉션 그리고 스스로 정의할 수 있는 클래스 객체가 있음, 또한 객체에 속한 모든 것도 힙에 저장이 됨
        // 정적 변수 또한 Heap 에 할당이 됨, Heap 은 JVM Garbage Collector 가 관리하고 통제를 함,
        // 객체는 레퍼런스가 최소 하나라도 있으면 Heap 에 머무름, 객체에 모든 Reference 가 사라지면 GC 에 의해 수거 됨

        // 멤버 변수는 부모 객체와 묶여 부모 객체와 같은 Life Cycle 을 가짐, 정적 변수는 어플리케이션이 실행되는 내내 그 자리에 머뭄

        // Heap (Shared) - Objects / Class Members / Static Variables (Thread 내에서 공유가 됨)
        // Stack (Exclusive) - Local Primitive Types / Local References (특정 Thread 내에서만 속함)

        int x = 1;
        int y = 1;

        int result = sum(x, y);

        System.out.println("[PRIND SUM ] : " + result);

        // 객체와 Reference 는 엄연히 다름

        // 객체 Reference 유형인 tc 를 선언, new TestClass(); 를 할당
        // tc1 에는 tc 를 할당 이것도 객체 Reference 유형임 (tc 와 같은 값을 할당)
        // Reference 가 메서드에 Local 변수로 선언이 되면 레퍼런스는 Stack 에 할당
        // 그리고 클래스의 멤버일 경우에는 부모 갬체와 함꼐 Heap 상단에 할당
        
        // 반면 객체는 항상 Heap 에 할당이 됨
        TestClass tc = new TestClass();
        TestClass tc1 = tc;

    }

    public static int sum(int a, int b) {
        int sum = a + b;
        return sum;
    }

}

class TestClass {
    public String name;

    public int age;
}
