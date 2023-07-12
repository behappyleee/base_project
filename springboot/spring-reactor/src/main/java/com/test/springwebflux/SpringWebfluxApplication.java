package com.test.springwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebfluxApplication {

    /**
     *  대부분 전통적인 Application 들은 Blocking Call 을 사용 하였다 (동기 적인 Call).
     *  이 말은 특정 Resource 에 접근하고 싶을 시에 대부분 Thread 들은 사용 중 이였다.
     *  그러면 Application 들은 새로운 Thread 를 하나 생성 하거나 Thread 가 작업을 마칠 때 까지 기다렸다.
     *  
     *
     *
     *
     *
     * */
    // Spring Webflux



    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxApplication.class, args);
    }

}
