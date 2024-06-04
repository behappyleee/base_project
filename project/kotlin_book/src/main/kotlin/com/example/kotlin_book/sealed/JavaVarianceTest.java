package com.example.kotlin_book.sealed;

public class JavaVarianceTest {

    public void funTest() {
        Number[] test1 = new Number[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] test2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        // Compile 에러가 발생 ... !
//        test2[0] = 3;
//        test2[1] = 2.5;

    }
}
