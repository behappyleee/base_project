package com.spring.webflux.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

//@Configuration
//@EnableReactiveMongoRepositories
// public class MongoReactiveApplication extends AbstractReactiveMongoConfiguration {

public class MongoReactiveApplication {

    // @Bean
    // @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    // @Override
    protected String getDatabaseName() {
        return "reactive";
    }

}
