package com.sample.annotation;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})    // 해당 Annotation 경고 무시가 가능
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
     * 만약 많은 Legacy Code 가 존재 시 만약 많은 변화를 주기를 원하지 않을 것이다 그러면 많은 QA 테스트를 진행하여야 한다.
     * 그렇기에 그냥 @SurpressWarning 어노테이션을 사용하여 경고를 무시한다.
     *
     * **/
    public static void main(String[] args) {
        // Java 5 버전 이전에는 Map 에 데이터 저장 시 RawType 으로 데이터 저장이 가능하였음
        Map map = new HashMap();

        // Warning 을 제거하기 위하여서는 Map<String, String> 처럼 Type 을 지정 해 주어야 Warning 이 발생하지 않음

        map.put("test_key", "test_value");
        map.put("test1_key", "test1_value");
        map.put("test2_key", "test2_value");

        
        // DeprecatedMethod 를 호출 시 Warning 이 발생
        deprecatedMethod();

    }

    @Deprecated
    public static void deprecatedMethod() {
        System.out.println("THIS IS DEPRECATED METHOD TEST IN Standard Annotation Class");
    }


}



