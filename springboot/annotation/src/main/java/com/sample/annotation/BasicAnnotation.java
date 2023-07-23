package com.sample.annotation;

public class BasicAnnotation {

    // Annotation
    // An annotation is preceded by the @symbol. Some common examples of annotations
    // @Override and @SurpressWarning These are built in annotations provided by Java through
    // the java.lang package. We can further extend the core functionally to provide our custom annotations.

    // An annotation by itself does not perform any action. It simply provides information
    // that can be used at compile time or runtime to perform further processing.

    public static void main(String[] args) {


    }

}

// Override Annotation 사용 예시
// @Override - annotation to mark a method that exists in a parent class.
class ChildClass extends ParentClass {
    // Override 어노테이션은 만약 Parent Class 에 Override 할 메서드가 없으면 에러를 내뱉음 (엄격히 관리가 가능)
    @Override
    public void getName() {
        System.out.println("THIS IS TEST METHOD AT OVERRIDE ANNOTATION TEST");
    }
}

class ParentClass {
    public void getName() {
        System.out.println("THIS IS TEST METHOD IN OVERRIDE TEST CLASS");
    }
}

