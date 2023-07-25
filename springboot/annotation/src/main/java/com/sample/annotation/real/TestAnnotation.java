package com.sample.annotation.real;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotation {

    public static void main(String[] args) {

        Class <AnnotatedMethod> annotatedMethodClass = AnnotatedMethod.class;
        // By calling getDeclaredMethods() we're getting the methods of our AnnotatedMethods class. Then.
        // we are iterating through the methods and checking each method if it is annotated with the @Test annotation.

        // Finally we perform a runtime invocation of the methods that were identified as beging annotated with @Test

        for(Method method : annotatedMethodClass.getDeclaredMethods()) {
            Annotation annotation = method.getAnnotation(Test.class);
            Test test = (Test) annotation;

            // If the annotation is not null
            if(test != null) {
                try {
                    method.invoke(annotatedMethodClass
                                    .getDeclaredConstructor()
                                    .newInstance());
                } catch(Throwable ex) {
                    System.out.println(ex.getCause());
                }
            }

        }


    }

}
