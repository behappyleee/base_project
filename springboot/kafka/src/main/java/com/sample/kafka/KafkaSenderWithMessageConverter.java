package com.sample.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderWithMessageConverter {

    private final Logger logger = LoggerFactory.getLogger(KafkaSenderWithMessageConverter.class);

    @Autowired
    private KafkaTemplate<String, ?> kafkaTemplate;

    public void sendMessageWithConverter(Message<?> user) {
        logger.debug("Sending With Message Converter : {} " , user);
        logger.debug("-------------------------------------------------------------------");

        kafkaTemplate.send(user);
    }

}
