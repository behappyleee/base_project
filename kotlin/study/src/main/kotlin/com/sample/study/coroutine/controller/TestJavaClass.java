package com.sample.study.coroutine.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJavaClass {

    public static void main(String[] args) {
        GenericBox<Double> aa = new GenericBox<>();
        aa.data = 3;

        GenericBox<Double> bb = new GenericBox<>();
        bb.data = 6;

        double cc = aa.getAverage(bb);
        System.out.println("[AVERAGE ] : " + cc);

        // 생성이 불가능 Bounded Type Parameter 로 Number 를 넘겨줌
        // TestBoundedGeneric<String> dd = new TestBoundedGeneric<String>();
        TestBoundedGeneric<Integer> dd = new TestBoundedGeneric<>();


    }

}

class GenericBox<T> {

    double data;

    public double getAverage(GenericBox<T> a) {
        return ((Double)this.data + a.data) / 2;
    }
}

// Bounded Type Parameter
// BoundedGenericBox <T extends Number> --> 어떤 타입 T 인자를 받을 수 있는 데 Number 인터페이스 또는
// 클래스 이거나 상속 받은 타입 즉 하위 타입만 받도록 가능
class TestBoundedGeneric<T extends Number> {

    public void testFun() {
        List<T> aa = new ArrayList<>();


    }

    public static <KEY, VALUE> void genericTest(KEY a, VALUE b) {
        List<KEY> keys = new ArrayList<>();
        keys.add(a);

        Map<KEY, VALUE> hashMap = new HashMap<>();
        hashMap.put(a, b);

    }

}

class TestGeneric<T, A> {

    public <S> S testFun (S a) {
        return a;
    }

}
