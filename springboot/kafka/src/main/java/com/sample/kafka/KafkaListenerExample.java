package com.sample.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerExample {

    private final Logger logger = LoggerFactory.getLogger(KafkaListenerExample.class);

    @KafkaListener(topics = "test_topic_1")
    public void listener(String message) {
        logger.debug("THIS IS LISTENER : {} ", message);
    }

    @KafkaListener(topics = {"test_topic_1", "test_topic_2"}, groupId = "test-group-1")
    public void multipleListener(String message) {
        logger.debug("THIS IS LISTENER : {} ", message);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "reflectoring-3", partitionOffsets = {
            @PartitionOffset(partition = "0", initialOffset = "0") }), groupId = "reflectoring-group-3")
    void listenToParitionWithOffset(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                                    @Header(KafkaHeaders.OFFSET) int offset) {
        logger.info("ListenToPartitionWithOffset [{}] from partition-{} with offset-{}", message, partition, offset);
    }

    @KafkaListener(topics = "reflectoring-bytes")
    void listenerForRoutingTemplate(String message) {
        logger.info("RoutingTemplate BytesListener [{}]", message);
    }

    @KafkaListener(topics = "reflectoring-others")
    @SendTo("reflectoring-2")
    String listenAndReply(String message) {
        logger.info("ListenAndReply [{}]", message);
        return "This is a reply sent to 'reflectoring-2' topic after receiving message at 'reflectoring-others' topic";
    }

    @KafkaListener(id = "1", topics = "reflectoring-user", groupId = "reflectoring-user-mc", containerFactory = "kafkaJsonListenerContainerFactory")
    void listenerWithMessageConverter(User user) {
        logger.info("MessageConverterUserListener [{}]", user);
    }

}
