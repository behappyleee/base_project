package com.test.springboot_test.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SpringBootTest
public class OptionalNullTest {

    // Optional 과 Null 차이
    // Java 에서 제공하는 객체를 Optional 객체로 감싸기 위하여서는 Optional 에서 제공하는 of 와 ofNullable 메서드를 사용
    // 둘의 차이점은 of 는 인자로서 null 값을 받지 않는 다는 것이고 ofNullable 은 Null 값을 허용 하는 것

    @Test
    public void optionalTest() {
        Map <String, Object> optionalMap = new HashMap<String, Object>();

        // NULL 허용 안함
        // Optional.of(optionalMap.get("test"));
        
        // NULL 허용 함
        Optional.ofNullable(optionalMap.get("TEST"));

    }


}
