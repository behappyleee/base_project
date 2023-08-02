package com.sample.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    private final Logger logger = LoggerFactory.getLogger(KafkaProducerConfig.class);

    @Value("${io.kafka.bootstrap-servers}")
    private String bootstrapServer;



}
