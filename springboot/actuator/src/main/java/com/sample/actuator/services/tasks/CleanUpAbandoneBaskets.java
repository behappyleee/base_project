package com.sample.actuator.services.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CleanUpAbandoneBaskets {

    @Scheduled(fixedDelay = 900000)
    public void process() {
        System.out.println("Cleaning Abandone baskets, current time : "  + new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
