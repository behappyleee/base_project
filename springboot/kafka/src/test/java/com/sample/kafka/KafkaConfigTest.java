package com.sample.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaConfigTest {

    @Value("${io.kafka.bootstrap-servers}")
    private String serverValue;

    @Test
    public void KafkaConfigValueTest() {

        System.out.println("SERVER VALUE DATA TEST CHECK : " + serverValue);

    }


}
