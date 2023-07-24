package com.sample.annotation.custom;

public class CustomAnnotation {

    // Custom Annotation 사용 이유
    // 1. Reduce Repetition
    // 2. Automate the generation of boilerplate code
    // 3. Catch errors at compile time such as potential null pointer checks
    // 4. Customize Runtime behavior based on the presence of a custom annotation

    /**
     *  Annotation 을 Custom 하기 위하 여서는 @interface 어노테이션을 사용하여 어노테이션을 생성 하면 된다.
     *
     * 어노테이션의 특정 정보 범위를 지정하기 위하여 (Compile 타임인지 or Runtime 인지에 대하여)
     * Meta Annotation 을 Customizing 을 한 Annotation 정보에 기입을 해주어여 한다.
     *
     *  ex) @Target(ElementType.TYPE), -> 이 해당 어노테이션 표시는 오직 Class 들에만 적용한다는 어노테이션 표식이다.
     *  ex) @Retention(RetentionPolicy.RUNTIME) -> 이 해당 어노테이션은 오직 Runtime 시에만 가능 하다는 어노테이션 이다.
     *
     *
     * */


}



