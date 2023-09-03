package com.sample.jackson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

// TODO 해당 어노테이션 생성 안해 줄 시 Run Error 발생 함 (UserMapper 를 Bean 으로 못 찾는 다는 에러가 발생 ...)
@ComponentScan(basePackages = "com.sample.jackson.mapper")
public class JacksonApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacksonApplication.class, args);
	}

}
