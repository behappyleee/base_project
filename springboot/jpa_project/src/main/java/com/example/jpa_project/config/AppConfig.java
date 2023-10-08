package com.example.jpa_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// spring-data-jpa 는 어플리케이션을 실행할 시 basePackages 에 있는 리포지토리 인터페이스를 찾아서 해당 인터페이스를 구현한 클래스를 동적으로
// 생성 한 다음 빈으로 등록, 따라서 개발자가 직접 구현 클래스를 만들지 않아도 된다.
@Configuration
@EnableJpaRepositories(basePackages = "com.example.jpa_project.repository")
public class AppConfig {



}
