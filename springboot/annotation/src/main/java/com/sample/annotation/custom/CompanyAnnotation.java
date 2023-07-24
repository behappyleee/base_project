package com.sample.annotation.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)               // 오직 Class 에만 적용 가능 하다는 메타 어노테이션 정보
@Retention(RetentionPolicy.RUNTIME)     // 오직 Runtime 시에만 사용이 된 다는 메타 어노테이션 정보
public @interface CompanyAnnotation {

    String name() default "ABC";    // 해당 어노테이션 사용 시 이름 지정 (기본 값 ABC)

    String city() default "XYZ";    // 해당 어노테이션 사용 시 도시 지정 (기본 값 XYZ)

}
