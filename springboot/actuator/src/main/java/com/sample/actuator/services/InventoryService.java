package com.sample.actuator.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InventoryService {

    @Scheduled(cron = "0 0 12 * * *")
    public void generateReports() {
        System.out.println("Generating Reports !!!");
    }

}
