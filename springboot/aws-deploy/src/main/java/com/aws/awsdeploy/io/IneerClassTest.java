package com.aws.awsdeploy.io;

public class IneerClassTest {

    private int[] data;

    class InnerTest {}

    // 외부 클래스 생성자
    public IneerClassTest(int size) {
        data = new int[size];
    }

    InnerTest getInnerObject() {
        return new InnerTest();
    }

    static class Test {
        public String thisIs;
    }

    public static void main(String[] args) {

    }

}
