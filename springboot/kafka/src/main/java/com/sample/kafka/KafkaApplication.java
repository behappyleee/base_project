package com.sample.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaApplication {

	// TODO
	// 해당 자료 보고 학습 필요 !!
	// https://reflectoring.io/spring-boot-kafka/

	// Traditional Messaging Queues like Active MQ / Rabbit MQ can handle high throughput usually used for long-running
	// or background jobs and communicationg between services.

	// Kafka is a stream-processing platform build by Linkedin and currently developed under the umbrella of the apache software.

	// Kafka aims to provide low-latency ingestion of large amounts of event data.

	// Producer - A producer is a client that sends messages to the kafka server to the specified topic.

	// Consumer - Consumers are the recipients who receive messages from the Kafka Server.

	// Broker - Brokers can create a Kafka cluster by sharing information using Zookeeper. A broker receives message from
	//          producers and consumers fetch messages from the broker by topic, partition, and offset.


	// Cluster - Kafka is a distribution system. A Kafka cluster contains multiple brokers sharing the workload.



	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
