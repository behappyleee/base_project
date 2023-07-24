package com.sample.annotation;

/**
 * @FunctionalInterface
 *
 * 해당 어노테이션을 사용하는 것은 좋은 관습이다. 해당 어노테이션은 Lambda 를 사용하는 Interface 에는
 * 무조건 사용을 하여야 한다.
 *
 * */

// 오직 1개의 Abstract method 만 존재하도록 가능
@FunctionalInterface    // 해당 어노테이션은 인터페이스에 메서드가 단 1개만 존재하도록 보장
public interface FuncationalInterfaceTest {
    
    // 오직 @FunctionalInterface 어노테이션이 존재 시 오직 메서드 1개만 존재하도록 가능
    // FunctionalInterface 가 존재 하기에 ERROR 가 발생 !!!
    // void call();


    public void test();

}
