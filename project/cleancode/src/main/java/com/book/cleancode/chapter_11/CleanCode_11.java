package com.book.cleancode.chapter_11;

import java.util.List;

public class CleanCode_11 {

    // 창발성
    // 설계가 단순해지는 규칙
    // 1. 모든 테스트를 실행
    // 2. 중복을 없앰
    // 3. 프로그래머의 의도를 표현
    // 4. 클래스와 메서드 수를 최소로 줄임

    // 검증이 불가능한 시스템은 절대로 출시를 하면 안 됨
    // 테스트 케이스를 만들고 계속 돌려라 간단하고 단순한 규칙을 따르면 시스템은 낮은 결합도와 높은 응집력 이라는
    // 객체 지향 방법론 목표를 저절로 달성
    // 다중 스레드 코드는 떄떄로 말이 안되는 오류를 일으킨다. 쓰레드 코드에 잠입한 버그는 실패를 재현하기가 아주 어렵다.
    // 다중 쓰레드를 쓰는 코드 부분을 다양한 환경에 쉽게 끼워 넣을 수 있게 쓰레드 코드를 구현한다.

    // 처음부터 그리고 자주 모든 목표 플랫포메서 코드를 돌려보아야 한다.

    // 사용하는 라이브러리와 기본 알고리즘도 이해하여야 한다. 특정 라이브러리 기능이 기본 알고리즘과 유사한 문제를 어떻게 해결하는 지도 파악하여야 한다.
    // 스레드 코드는 출시 전까지 최대한 오랫동안 돌려봐야 한다

    public void testMethodA(List<?> testList) {

    }

    public <E> void testMethod(List<E> testList) throws InterruptedException {
        E e = null;

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 Start ! Thread Name : " + Thread.currentThread().getName());
        });


        for(int i=0; i<100_000; i++) {

        }

        Object.class.wait();

    }




}





class Duplicate_Check {

    int size() {
        return 0;
    }

    // isEmpty 메서드에서 szie 메서드를 이용하면 코드를 중복하여 구현할 필요가 없다.
    boolean isEmpty() {
        return size() == 0;
    }
}

class VacationPolicy_1 {
    public void accrueUSDDivisionVacation() {
        // 지금까지 근무한 시간을 바탕으로 휴가 일수를 계산하는 코드
        // ...
        // 휴가 일수가 미국 최소 법정 일수를 만족하는지 확인하는 코드
        // ...
        // 휴가 일수를 급여 대장에 적용하는 코드
        // ...
    }

    public void accrueEUDivisionVacation() {
        // 지금까지 근무한 시간을 바탕으로 휴가 일수를 계산하는 코드
        // ...
        // 휴가 일수가 유럽연합 최소 법정 일수를 만족하는지 확인하는 코드
        // ...
        // 휴가 일수를 급여 대장에 적용하는 코드
        // ...
    }
}
// 최소 법정 일수를 계산하는 코드만 제외를 하면 두 메서드는 거의 동일, 최소 법정 일수를 계산하는 알고리즘은 직원 유형에 따라 살짝 변함
// 여기에 Template Method 패턴을 적용하여 눈에 들어오는 중복을 제거
// 코드는 개발자의 의도를 분명히 표현하여야 한다. 개발자가 코드를 명백히 짤 수록 다른 사람이 그 코드를 이해하기도 쉬워진다.
// Template Method 적용 패턴
abstract  class VacationPolicy_2 {
    public void accrueVacation() {
        // caculateBseVacationHours();
        alterForLegalMinimums();
        applyToPayroll();
    }

    private void calculateBaseVacationHours() { /* ... */ };
    abstract protected void alterForLegalMinimums();
    private void applyToPayroll() { /* ... */ };
}

class USVacationPolicy extends VacationPolicy_2 {
    @Override protected void alterForLegalMinimums() {
        // 미국 최소 법정 일수를 사용한다.
    }
}

class EUVacationPolicy extends VacationPolicy_2 {
    @Override protected void alterForLegalMinimums() {
        // 유럽연합 최소 법정 일수를 사용한다.
    }
}

