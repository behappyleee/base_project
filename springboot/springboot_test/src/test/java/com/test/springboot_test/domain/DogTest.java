package com.test.springboot_test.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DogTest {
    
    /**
     * @BeforeAll
     *
     * 해당 어노테이션 사용 시 모든 @Test 클래스 로딩 시 딱 한번만 사용 !
     */
    @BeforeAll
    public static void init() {
        System.out.println("DogTest Class Init !!! [BeforeAll Annotation]");
    }

    /**
     * @BeforeEach
     *
     * 해당 어노테이션은 모든 테스트 메서드가 각 실행 전 해당 어노테이션 메서드 실행
     * */
    @BeforeEach
    public void doEach() {
        System.out.println("Hey Dog Before Test [BeforeEach Annotation]");
    }

    /**
     * @AfterAll
     *
     * 해당 어노테이션은 모든 테스트 메서드 실행을 마친 후 딱 한 번만 실행
     * */
    @AfterAll
    public static void afterAll() {
        System.out.println("Hey Dog After Test [AfterAll Annotation]");
    }

    /**
     * @AfterEach
     *  
     * 해당 어노테이션은 모든 테스트 메서드 실행 후 해당 어노테이션 메서드 실행
     * */
    @AfterEach
    public void afterEach() {
        System.out.println("Hey Dog After Test [AfterEach Annotation]");
    }

    @Test
    public void breakFailure() {
        String expectedString = "Meow";
        assertEquals(expectedString, "Woof");
    }
    
    /**
     * @Disabled
     *
     * 해당 어노테이션은 해당 어노테이션 메서드 실행 하지 않음
     * */    
    @Disabled("Dog 1 please don't woof !!!!")
    @Test
    public void testBark1() {
        String expectedString = "woof1";
        assertEquals(expectedString, "woof1");
        System.out.println("WOOF 1 [Disabled Annotaion !!!]");
    }

    @Test
    public void testBark2() {
        String expectedString = "woof2";
        assertEquals(expectedString, "woof2");
        System.out.println("WOOF => 2");
    }

    @Test
    public void testNotBark() {
        String unexpectedString = "";
        assertNotEquals(unexpectedString, "woof");
        System.out.println("Didn't woof!!");
    }

    @Test
    public void nullCheck() {
        Object dog = null;
        assertNull(dog);    // 해당 객체가 Null 인지 확인
        System.out.println("Null dog :(");
    }

    @Test
    public void nonNullCheck() {
        String dog = "Max";
        assertNotNull(dog); // 해당 객체가 Null 이 아닌 지 확인
        System.out.println("Hey I am " + dog);
    }

    @Test
    public void trueCheck() {
        int dogAge = 2;
        assertTrue(dogAge < 5); // 해당 Age 가 5 이하 인지 확인
        System.out.println("I am young :)");
    }

    @Test
    public void falseCheck() {
        int dogAge = 7;
        assertFalse(dogAge < 5);    // 해당 Age 가 5 이하 아닌지 확인
        System.out.println("I am old :(");
    }

}
