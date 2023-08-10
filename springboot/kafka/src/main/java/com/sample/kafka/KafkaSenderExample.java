package com.sample.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.RoutingKafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class KafkaSenderExample {

    private final Logger logger = LoggerFactory.getLogger(KafkaSenderExample.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private RoutingKafkaTemplate routingKafkaTemplate;
    private KafkaTemplate<String, User> userKafkaTemplate;

    @Autowired
    KafkaSenderExample(KafkaTemplate<String, String> kafkaTemplate, RoutingKafkaTemplate routingKafkaTemplate,
                       KafkaTemplate<String, User> userKafkaTemplate) {
        this.kafkaTemplate =kafkaTemplate;
        this.routingKafkaTemplate = routingKafkaTemplate;
        this.userKafkaTemplate = userKafkaTemplate;
    }

    public void sendMessage(String message, String topicName) {
        logger.debug("THIS IS SENDING : {} " , message);
        logger.debug("-----------------------------------------------------------------------------");

        kafkaTemplate.send(topicName, message);
    }

    public void sendWithRoutingTemplate(String message, String topicName) {
        logger.debug("SEND ROUNT TEMPLATE SENDING MESSAGE : {} ", message);
        logger.debug("------------------------------------------------------------------------------");

        routingKafkaTemplate.send(topicName, message.getBytes());
    }

    public void sendCustomMessage(User user, String topicName) {
        logger.debug("Sending Json Serializer : {} ", user);
        logger.debug("-------------------------------------------------------------------------------");

        userKafkaTemplate.send(topicName, user);
    }

    public void sendMessageWithCallback(String message, String topicName) {
        logger.debug("String Content Message : {} ", message);
        logger.debug("--------------------------------------------------------------------------------");

        // Future<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

        // TODO
        // Deprecated 된 Method 임 확인 후 변경 필요 !!!
        ListenableFuture<SendResult<String, String>> future = (ListenableFuture<SendResult<String, String>>) kafkaTemplate.send(topicName, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.debug("Success Callback : [ {} ] delivered with offset", message, result.getRecordMetadata().offset());
            }
            @Override
            public void onFailure(Throwable ex) {
                logger.warn("Failure Callback : Unable to deliver message [{}], {}", message, ex.getMessage());
            }
        });
    }

}
