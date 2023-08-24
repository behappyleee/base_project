package com.sample.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class ActuatorApplication {

	// Actuator 설정 시 노출 엔드 포인트를 통하여 모니터링 가능한 데이터를 제공
	// Springboot Actuator 는 SpringBoot 하위 프레임워크 프로젝트임
	// SpringBoot Actuator 는 어플리케이션을 모니터링하고 관리하는데 도움이 되는 여러가지 추가 기능이 포함되어 있음
	// HTTP 및 JMX 엔드 포인트를 사용하여 SpringBoot 어플리케이션을 관리하고 모니터링이 가능함

	// SpringBoot Actuator 3가지 중요한 개념

	// 1. Endpoints
	// Actuator 끝 점을 통하여 Application 모니터링이 가능한 application.properties 에서 설정 한 노출 Endpoint URL 을 통하여 접근 가능
	// ex) health 보고 싶을 시 /actuator/health Endpoint 로 접근

	// 2. Metrics
	// Application 에 핵심이 되는 정보들 이 어플리케이션이 사용 되는 메모리, CPU 가 어느 정도 되는 지 그런 정보들을 여러 모니터링 어플리케이션
	// 사용할 수 있는 공통의 포맷을 만들어서 제공

	// 3. Audit
	// SpringBoot Security 가 실행이 되면 SpringBoot Acutator 에는 이벤트를 게시하는 감사 프레임워크가 있음 (기본적으로 인증 성공, 실패, 및 액세스 거부 등)
	// 이 기능은 인증 실패를 기반으로 잠금 정책을 보고하고 구현하는 데 매우 유용
	// AuditEventRepository 애플리케이션 구성 에 유형의 Bean을 제공하여 감사를 사용


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ActuatorApplication.class);
		// SpringApplication 시작 시 시간 살짞 늦춰 줌
		app.setApplicationStartup(new BufferingApplicationStartup(2048));
		app.run(args);

		// SpringApplication.run(ActuatorApplication.class, args);
	}

}
