package com.test.springboot_test.domain;

import com.test.springboot_test.dummy.domain.GoldFish;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Properties;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class GoldFishTest {
    
    // User System 환경 정보 출력
    @Disabled("THIS IS DISABLED DUE TO TOO LONG PRINTING")
    @Test
    public void printSystem() {
        Properties properties = System.getProperties();

        properties.forEach((key, value) -> {
            System.out.println("PROPERY KEY : " + key.toString() + " VALUE : " + value);
        });

    }

    @Test
    public void testBooleanAssumption() {
        GoldFish goldFish = new GoldFish("Windows Jelly", 1);

        assumeTrue(System.getProperty("os.name").contains("Windows"));  // OS 인지 확인
        assertThat(goldFish.getName(), equalToIgnoringCase("Windows Jelly"));
    }

    @Test
    public void testBooleanAssert() {
        GoldFish goldFish = new GoldFish("Windows Jelly", 1);

        assert(System.getProperty("os.name").contains("Windows"));
        assertThat(goldFish.getName(), equalToIgnoringCase("Windows Jelly"));
    }

    @Test
    public void testException() {
        GoldFish goldFish = new GoldFish("Goldy", 0);

        // 해당 Excepion 이 실행 되는 지 확인이 필요
        RuntimeException exception = assertThrows(RuntimeException.class, goldFish::calculateSpeed);

        // Exception 의 Message 가 실행 되었는 지 확인
        assertThat(exception.getMessage(), equalToIgnoringCase("AGE COULD NOT BE ZERO"));
    }

    @ParameterizedTest
    @MethodSource("provideFishes")  // MethodSource 어노테이션 사용 시 테스트 데이터 제공
    public void parameterizedTest(GoldFish goldFish) {
        assertTrue(goldFish.getAge() >= 1);
    }

    private static Stream<Arguments> provideFishes() {
        return Stream.of(
            Arguments.of(new GoldFish("Browny", 1)),
                Arguments.of(new GoldFish("Greeny", 2))
        );
    }
}
