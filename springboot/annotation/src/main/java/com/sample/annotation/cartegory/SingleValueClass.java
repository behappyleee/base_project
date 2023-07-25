package com.sample.annotation.cartegory;

import java.lang.annotation.Annotation;

@SingleValueAnnotation(value = "TEST")
public class SingleValueClass {

    private int id;
    private String name;

    public SingleValueClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void singleValueDetail() {
        System.out.println("Value Detail ID : " + id);
        System.out.println("Value Detail Name : " + name);
    }

    public static void main(String[] args) {
        SingleValueClass singleValueClass = new SingleValueClass(1, "John");
        singleValueClass.singleValueDetail();

        Annotation companyAnnotation = singleValueClass
                .getClass()
                .getAnnotation(SingleValueAnnotation.class);

        // Annotation 정보를 가져옴 !
        SingleValueAnnotation singleValueAnnotation = (SingleValueAnnotation) companyAnnotation;

        System.out.println("COMPANY NAME DATA TEST CHECK : " + singleValueAnnotation.value());

    }

}
