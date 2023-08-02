package com.sample.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${io.spring.kafka.topic-1}")
    private String topic1;

    @Value("${io.spring.kafka.topic-1}")
    private String topic2;

    @Value("${io.spring.kafka.topic-1}")
    private String topic3;

    @Value("${io.spring.kafka.topic-1}")
    private String topic4;

    @Bean
    NewTopic topic1() {
        return TopicBuilder.name(topic1).build();
    }

    @Bean
    NewTopic topic2() {
        return TopicBuilder.name(topic2).build();
    }

    @Bean
    NewTopic topic3() {
        return TopicBuilder.name(topic3).build();
    }

//    @Bean
//    NewTopic topic4() {
//        return TopicBuilder.name(topic4).build();
//    }

    @Bean
    NewTopic topicUser() {
        return TopicBuilder.name(topic4).build();
    }

    @Bean
    NewTopic topicBytes() {
        return TopicBuilder.name("topic_bytes_kafka").build();
    }

    @Bean
    NewTopic others() {
        return TopicBuilder.name("topic_others_kafka").build();
    }

}
