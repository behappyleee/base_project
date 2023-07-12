package com.test.springwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebfluxApplication {

    // TODO
    // Intro to Java 9 Reactive Streams API 부터 학습 필요 !!!
    // https://reflectoring.io/getting-started-with-spring-webflux/

    /**
     *  대부분 전통적인 Application 들은 Blocking Call 을 사용 하였다 (동기 적인 Call).
     *  이 말은 특정 Resource 에 접근하고 싶을 시에 대부분 Thread 들은 사용 중 이였다.
     *  그러면 Application 들은 새로운 Thread 를 하나 생성 하거나 Thread 가 작업을 마칠 때 까지 기다렸다.
     *
     *  만약 Big 데이터를 저리하고 싶을 시 빠른 처리가 필요하였고 Software Developer 들은 Multi Thread 들이
     *  필요하단 것을 꺠달았다. (Asynchronous 와 Non-Blocking Call) 이 최선의 선택이였다.
     *
     *
     * */

    /**
     *  Stream 에 대한 이해가 필요하다. Stream 은 한 시스템에서 다른 시스템으로 연속적으로 데이터를 보내주는 것이다.
     *  이것은 전통적으로 FIFO 방식으로 작동한다.
     *
     *  Reactive System 은 반드시 Asynchronous 여야하며 Producer (Consumer 에게 메세지를 보내는 단 하나의 책임만 존재하는)
     *  들을 다루어야 한다.
     *
     *
     *
     * */


    // Spring Webflux

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxApplication.class, args);
    }

}
