package com.sample.annotation;

import java.util.HashMap;
import java.util.Map;

public class StandardAnnotation {

    // Standard Annotation - These are standard Annotation that Java provides as part of
    // the java.lang package. To see their full effect it would be best to run the code snippets
    // from the command line since most IDEs provide their custom options that alert warning levels.

    /**
     * @SurpressWarning
     * To indicate warnings on code complination should be ignored. We may want to suppress warnings
     * that clutter up the build output.
     * Supress Warnings associated with raw types.
     *
     *
     *
     * **/

    public static void main(String[] args) {
        // Java 5 버전 이전에는 Map 에 데이터 저장 시 RawType 으로 데이터 저장이 가능하였음
        Map map = new HashMap();

        // Warning 을 제거하기 위하여서는 Map<String, String> 처럼 Type 을 지정 해 주어야 Warning 이 발생하지 않음

        map.put("test_key", "test_value");
        map.put("test1_key", "test1_value");
        map.put("test2_key", "test2_value");

    }

}



