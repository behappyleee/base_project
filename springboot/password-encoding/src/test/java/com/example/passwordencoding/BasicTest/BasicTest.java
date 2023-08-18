package com.example.passwordencoding.BasicTest;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class BasicTest {

    @Test
    public void interfaceMethodTest() {
        String[] arrayTest = new String[3];

        arrayTest[0] = "1";
        arrayTest[1] = "2";
        arrayTest[2] = "3";

        StringDefaultTest strDefault = test -> {
            System.out.println("TEST CHECK : " + test);
        };

        strDefault.strTest(arrayTest);
        strDefault.strTest("1", "2", "3");
        strDefault.strTest("1", "2", "3");

        StringDefaultTest strInterTest = new StringDefaultTest() {
            @Override
            public void strTest(String... test) {

            }
        };

        strInterTest.strTest();

        FunctionInterfaceTest funcT = (funcTest) -> {
            System.out.println("THIS IS SUCCESS FUNC TEST !!!");
        };

      funcT.functionTest(funcTest("sd"));

    }

    public void printArguments(String ... testArg) {
        for(String arg : testArg) {
            System.out.println("PARAM : " + arg);
        }
    }

    public Function<String, String> funcTest(String inputStr) {

        return null;
        //   return "This is FuncTest !!!";
    }

}




@FunctionalInterface
interface FunctionInterfaceTest {

    void functionTest(Function<String, String> func);

}

@FunctionalInterface
interface StringDefaultTest {

    void strTest(String ...test);
}


@FunctionalInterface
interface defaultInerface {

   void print();

}

