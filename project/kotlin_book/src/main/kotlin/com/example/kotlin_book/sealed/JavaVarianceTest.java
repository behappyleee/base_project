package com.example.kotlin_book.sealed;

public class JavaVarianceTest {

    Box_1<Super_1> te1 = new Box_1<Super_1>() {};
    Box_1<Super_2> te2 = new Box_1<Super_2>() {};
    Box_1<Super_3> te3 = new Box_1<Super_3>() {};

    public void funTest() {
        Number[] test1 = new Number[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] test2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        // Compile 에러가 발생 ... !
//        test2[0] = 3;
//        test2[1] = 2.5;

        // Java 는 공변임 ... !
        test1[2] = 0;
        test1[1] = 5.7;

        // Java 의 제네릭은 기본적으로 무공변 ... !!
        isInvari(new Box1());
        isInvari(new Box2());
        isInvari(new Box3());

    }

    public void isInvari(BoxCheck<Box2> sd) {

    }

    public void testIn(Box_1<Super_1> aa) {

    }

    public void testIn1(Box_1<? extends Super_2> aa) {

    }

    public void testIn2(Box_1<? super Super_2> aa) {

    }


    public void checkTest() {

     // te1 빼고 Compile Error 가 발생 ... !
          testIn(te1);
//        testIn(te2);
//        testIn(te3);

        // extends 는 공변 상위 타입은 안 됨 .... !! Super_2 의 하위 타입만 됨 .... !!
//         testIn1(te1);
         testIn1(te2);
         testIn1(te3);

         // super 는 반공변 하위 타입은 안 됨 ... !!
        testIn2(te1);
        testIn2(te2);
//        testIn2(te3);

    }
}


interface Box_1<T>{}

class Super_1 {}

class Super_2 extends Super_1{}

class Super_3 extends Super_2{}

class BoxCheck<T> {}

class Box1 extends BoxCheck {}

class Box2 extends Box1 {}

class Box3 extends Box2 {}