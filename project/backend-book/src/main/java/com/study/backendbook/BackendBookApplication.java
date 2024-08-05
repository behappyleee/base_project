package com.study.backendbook;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class BackendBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBookApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(DataSource dataSource) {
		return args -> {
			// 이 부분에 실행할 코드를 넣음 !
			Connection connection = dataSource.getConnection();

		};
	}
}
