package com.sample.annotation.cartegory;

import java.lang.annotation.Annotation;

@MultipleValueAnnotation(value = "test", numTest = 3, numArr = {1,2,3,4,5},testArr = {"1", "2", "3"})
public class MultipleAnnotationClass {

    public static void main(String[] args) {
        Annotation multipleValueAnnotation = new MultipleAnnotationClass()
                .getClass()
                .getAnnotation(MultipleValueAnnotation.class);

        MultipleValueAnnotation annotation = (MultipleValueAnnotation) multipleValueAnnotation;

        // 설정 된 값들 가져오기
        annotation.numArr();
        annotation.value();

    }

}
