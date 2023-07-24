package com.sample.annotation.meta;

import java.lang.annotation.Inherited;

public class MetaInheritedAnnotationTest {
    /**
     *   Meta Annotation - 메타 어노테이션들은 다른 어노테이션들에게 Compile or Runtime 환경인지 정보를 제공해주는 어노테이션이다.
     *
     *   Meta annotations can answer the following questions about an annotation:
     *
     *   Can the annotation be inherited by child classes?
     *   Does the annotation need to show up in the documentation?
     *   Can the annotation be applied multiple times to the same element?
     *   What specific element does the annotation apply to, such as class, method, field, etc.?
     *   Is the annotation being processed at compile time or runtime?
     *
     * */

    public static void main(String[] args) {

    }

}

// 기본적으로 Annotation 들은 상속이 안된다. Parent Class 로 부터, @InheritedAnnotation 을 적용 하면서 상속이 가능해진다.
@Inherited  // 헤당 어노테이션은
@interface CompanyTest {
    String name() default "ABC";
    String city() default "123";
}

@CompanyTest
class CustomAnnotation {
    private int id;
    private String name;
    public CustomAnnotation(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void getEmployeeDetails(){
        System.out.println("Employee Id: " + id);
        System.out.println("Employee Name: " + name);
    }
}

// @CompanyTest 어노테이션이 @Inherited 어노테이션을 메타 어노테이션으로 포함을 하고 있으므로
// CustomAnnotatedManager 해당 클래스는 포함시킬 필요가 없어진다.

class CustomAnnotatedManager extends CustomAnnotation{
    public CustomAnnotatedManager(int id, String name) {
        super(id, name);
    }
}



