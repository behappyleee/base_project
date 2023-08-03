package com.sample.rest.domain;

public enum Gender {

     MALE("Man")
   , FEMALE("Woman");

    private String gender;

     Gender(String gender) {
         this.gender = gender;
     }

     public String getGender() {
         return gender;
     }

}
