package com.study.graphql;


import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


public class AnnotationTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void searchAnnotation() {

        Class<? extends Annotation> annotationType = MyCustomAnnotation.class;

        System.out.println("Annotation Type : " + annotationType);

        Class<?>[] classes = MyCustomAnnotation.class.getClasses();

        System.out.println("CLASS LENGTH : " + classes.length);
        System.out.println("DATA TEST CHECK 1 : " + MyCustomAnnotation.class.getCanonicalName());
        System.out.println("DATA TEST CHECK 2 : " + MyCustomAnnotation.class.getPackage());
        System.out.println("DATA TEST CHECK 3 : " + MyCustomAnnotation.class.getSimpleName());

        Class<?>[] declaredClasses = MyCustomAnnotation.class.getDeclaredClasses();

        System.out.println("DECLARED CLASS LENGTH : " + declaredClasses.length);

        for(Class<?> eachClass : declaredClasses) {
            System.out.println("EACH CLASS NAME CHECK : " + eachClass.getName());
            System.out.println("EACH CLASS NAME DATA TEST CHECL : " + eachClass.getPackageName());
            System.out.println("EACH CLASS NAME TEST : " + eachClass.getCanonicalName());
        }

        for(Class<?> eachClass : classes) {
            System.out.println("CLASS NAME DATA TEST : " + eachClass.getName());
            System.out.println("EACH CLASS DATA CHECK : " + eachClass.getDeclaredMethods());
            System.out.println("EACH CLASS DATA CHECK TEST GET : " + eachClass.getCanonicalName());
            System.out.println("CLASS PACKAGE NAME DATA TEST : " + eachClass.getPackageName());
            System.out.println("SIMPLE NAME DATA TEST CHECK : " + eachClass.getSimpleName());
        }
    }

}

@MyCustomAnnotation
class customAnnotation {

}

@Target(ElementType.TYPE)
@interface MyCustomAnnotation {


}
