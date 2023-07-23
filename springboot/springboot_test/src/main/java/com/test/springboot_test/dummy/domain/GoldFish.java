package com.test.springboot_test.dummy.domain;

// This is class for testing
public class GoldFish {

    String name;
    int age;

    public GoldFish(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int calculateSpeed() {
        if(age == 0) {
            throw new RuntimeException("AGE COULD NOT BE ZERO");
        }
        return 10 / age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
