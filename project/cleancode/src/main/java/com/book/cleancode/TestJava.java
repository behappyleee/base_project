package com.book.cleancode;

public class TestJava {

    public static void main(String[] args) {
        // String.format()
        try {
            testException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String testException() throws Exception {
        return "This is Exception Test Method !";
    }

}

