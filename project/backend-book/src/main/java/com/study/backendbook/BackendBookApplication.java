package com.study.backendbook;

import com.study.backendbook.controller.product.repository.DatabaseProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
			
			// 커넥션을 가져오는 행위가 성공하면 애플리케이션과 데이터 베이스가 연결에 성공하였다는 의미
			// Application Runner 를 통하여 커넥션 풀을 초기화해주는 이유 중 하나는 커넥션 풀이 처음 사용되는 시점에 생성 된다는 점
			// 만약 커넥션 풀을 초기화 해주지 않는다면 애플리케이션이 시작 한 후 처음 받는 요청은 커넥션 풀이 생성되는 시간만큼 지연되어 클라이언트가 느리게 응답을 받음
			Connection connection = dataSource.getConnection();
		};
	}
}

