package com.sample.annotation.custom;

import java.lang.annotation.Annotation;

// Company 어노테이션을 사용 시 모두다 똑같은 name 과 city 를 가질 것이다.
// 그래서 더 이상 Constructor 에 정보를 추가를 하지 않아도 될 것이다.
// @CompanyAnnotation(name = "ABC", city = "123")
@CompanyAnnotation
public class CustomEmployee {

    private int id;
    private String name;

    public CustomEmployee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void getEmployeeDetails() {
        System.out.println("Employee ID : " + id);
        System.out.println("Employee NAME : " + name);
    }

    public static void main(String[] args) {
        // Can read a test ckass to read the @Company Annotation at Runtime
        CustomEmployee customEmployee = new CustomEmployee(1, "John");
        customEmployee.getEmployeeDetails();

        // 해당 Class 의 Annotation 의 정보가 접근이 가능 하므로 많은 반복 작업들을 줄여줄 수 있다.
        Annotation companyAnnotation = customEmployee
                .getClass()
                .getAnnotation(CompanyAnnotation.class);

        CompanyAnnotation company = (CompanyAnnotation) companyAnnotation;

        System.out.println("Company Name : " + company.name()); // 해당 어노테이션의 설정 된 Name 값을 가져옴
        System.out.println("Company City : " + company.city()); // 해당 어노테이션의 설정 된 City 값을 가져옴

    }

}
