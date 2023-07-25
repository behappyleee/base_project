package com.sample.annotation.cartegory;

public @interface MultipleValueAnnotation {

    String value();
    String[] testArr();
    int numTest();
    int [] numArr();

}
