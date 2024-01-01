package com.sample.study.instance;

public class JavaTest {

    public static void main(String[] args) {

        RecordTest rt = new RecordTest("TEST1");
        String aa =rt.testCheck();
        System.out.println(aa);

        String bb = rt.name();
        System.out.println(bb);

    }

}

class TestJavaClass {}

record RecordTest(String name) {

    public String testCheck() {
        return "THIS IS TEST !!";
    }

}
