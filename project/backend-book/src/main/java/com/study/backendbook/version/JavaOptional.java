package com.study.backendbook.version;

import org.springframework.lang.NonNull;

import java.util.Optional;

public class JavaOptional {

    // without Optional
    private static String getTestData() {
        return null;
    }

    private static Optional<String> getTestDataWithOptional() {
        return Optional.empty(); // null 을 반환하는 것이 아니라 optional 을 반환한다.
    }

    public static void main(String[] args) {
        // Optional 은 null 이 들어 있는 멤버 변수에 접근 시 우아하게 처리하기 위하여 사용
        String isNull = getTestData();

        // Null 을 확인해 주어야 한다.
        if (isNull != null) {
            System.out.println(isNull.toUpperCase());
        }

        Optional<String> isNullOptional = getTestDataWithOptional();
        isNullOptional.ifPresent(str -> System.out.println(str.toUpperCase()));


    }
}
