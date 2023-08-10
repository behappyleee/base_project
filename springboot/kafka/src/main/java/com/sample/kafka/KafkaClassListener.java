package com.sample.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "class-level", topics = "test_topic_1")
public class KafkaClassListener {

    private final Logger logger = LoggerFactory.getLogger(KafkaClassListener.class);

    @KafkaHandler
    public void listen(String message) {
        logger.debug("Kafka Class Listener String Message : {} ", message);
    }

    @KafkaHandler
    public void listenDefault(Object object) {
        logger.debug("Kafka Class Listener Handler Default : {} ", object);
    }

}
