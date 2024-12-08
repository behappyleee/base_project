package test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class ReflectionTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<TestClass> clazz = TestClass.class;
        Field field = clazz.getDeclaredField("privateName");

        Constructor<TestClass> aaa = clazz.getDeclaredConstructor(String.class, Integer.class, Array.class);
        var asdasd= aaa.newInstance("TEST CHECK", 3, new String[] {"A", "B", "C"});

        TestClass testClass = new TestClass();

        // setAccessible 을 true 로 변경 시 private 데이터 필드에도 접근이 가능하게 해 준다.
        field.setAccessible(true);
        var privateName = field.get(testClass);

        System.out.println("PRIVATE NAME : " + privateName);
        System.out.println("Field Name : " + field.getName());
        System.out.println("Field Value : ");

        String a = "";
        String b = "";


    }
}


class TestClass {

    private final String privateName = "This is Private Name !";
}
