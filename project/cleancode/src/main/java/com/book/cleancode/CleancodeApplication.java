package com.book.cleancode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CleancodeApplication {

    public static int numTest = 0;

    public synchronized static int getSyncNumTest() throws InterruptedException {
        Thread.sleep(2000);
        return numTest;
    }

    public static void main(String[] args) {
        numTest++;
        SpringApplication.run(CleancodeApplication.class, args);
    }
}
