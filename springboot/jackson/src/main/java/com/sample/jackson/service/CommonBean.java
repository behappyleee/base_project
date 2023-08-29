package com.sample.jackson.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBean {

    // Object Mapper
    // JSON 객체를 역직렬화 하기 위하여 Object Mapper 를 사용 (JACKSON 라이브러리 클래스)
    // ObjectMapper 를 사용 시 Java 를 JSON 객체로 변환도 가능 하고 JSON 을 Java 객체로 변환도 가능
    // 반대롤 JSON 객체를 Java 객체로 Serialization 도 가능
    
    // ObjectMapper 는 생성 비용이 비싸 Bean 또는 Static 으로 등록 후 사용
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new JavaTimeModule());

        return mapper;
    }


}
