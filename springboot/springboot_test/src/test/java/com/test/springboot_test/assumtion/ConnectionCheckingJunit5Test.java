package com.test.springboot_test.assumtion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

// @AssumeConnection(uri = "http://my.integration.system")
@AssumeConnection(uri = "https://naver.com")
public class ConnectionCheckingJunit5Test {

    @Test
    public void testOnlyWhenConnected() {
        
        // fail   -> 무조건 실패로 AssertionError 가 발생하고 다음 라인부터는 실행 되지 않음
        // assert -> 비교 검사나 조건이 실패하면 AssertionError 가 발생하고 다음 라인부터 실행 되지 않음
        // assume -> 조건이 실패 하면 AssumptionViloatedException 이 발생하고 다음 라인 부터 실행 되지 않음

        fail("Booh !!");
    }

}
