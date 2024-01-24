package thread.lock;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;

public class TryLockThread {

    // ReentrantLock 객체에 적용 된 synchronized 키워드 처럼 작동 함
    // 그렇지만 동기화 블럭과 달리
    public static void main(String[] args) {
        EnumSet<TestEnum> test = EnumSet.of(TestEnum.TEST_1, TestEnum.TEST_2);

    }

}

enum TestEnum{
    TEST_1,
    TEST_2
}
