package com.sample.annotation.meta;

import jakarta.el.ELManager;

import javax.xml.transform.Source;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RetentionAnnotationTest {

    // Retention
    // SOURCE - The annotation is used at compile time and discarded at runtime.
    // CLASS - The annotation is stored in the class file at compile time and discarded at run time.
    // RUNTIME - The annotation is retained at runtime.

    // If we needed an annotation to only provide error checking at compile time as @Override does,
    // We would use SOURCE. If we need an annotation to provide functionally at runtime such as @Test
    // in Junit We would use RUNTIME.

    public static void main(String[] args) {
        SourceRetention[] sourceRetention = new SourceRetentionAnnotationClass()
                .getClass()
                .getAnnotationsByType(SourceRetention.class);

        System.out.println("SourceRetention Class Length : " + sourceRetention.length);

        ClassRetention[] classRetentions = new ClassRetentionAnnotationClass()
                .getClass()
                .getAnnotationsByType(ClassRetention.class);

        System.out.println("ClassRetention Class Length : " + classRetentions.length);

        // Length 는 RuntimeRetention Annotation 만 클래스만 살아있으므로 해당 어노테이션 클래스만 렌스에 나옴 !
        RuntimeRetention[] runtimeRetentions = new RuntimeRetentionAnnotationClass()
                .getClass()
                .getAnnotationsByType(RuntimeRetention.class);

        System.out.println("Runtime Retention Length : " + runtimeRetentions.length);

    }

}

@SourceRetention
class SourceRetentionAnnotationClass {


}

@ClassRetention
class ClassRetentionAnnotationClass {

}

@RuntimeRetention
class RuntimeRetentionAnnotationClass {

}

@RuntimeRetention
class RuntimeRetentionAnnotationClass2 {

}

// is used at compile time and discarded at runtime.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@interface SourceRetention {

}

// Stored in the class file at compile time and discarded at run time.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
@interface ClassRetention {

}

// The annotation is retained at runtime.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface RuntimeRetention {

}






