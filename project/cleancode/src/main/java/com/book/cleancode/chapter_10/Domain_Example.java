package com.book.cleancode.chapter_10;

import org.apache.logging.log4j.ThreadContext;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.boot.autoconfigure.web.embedded.TomcatVirtualThreadsWebServerFactoryCustomizer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.management.ThreadInfo;
import java.util.concurrent.ThreadFactory;

public class Domain_Example {

    // 소프트웨어 분야에서도 최근 들어 DSL (Domain Specific Language) 가 새롭게 조명 받기 시작하였다.
    // DSL 은 간단한 스크립트 언어나 표준 언어로 구현한 API 를 가르킨다.
    // 효과적으로 사용한다면 DSL 은 추상화 수준을 코드 관용구나 디자인 패턴 이상으로 끌어올린다.

    // 모든 추상화 단계에서 의도는 명확히 표현하여야 한다. 그러려먼 POJO 를 작성해야 하고 관점 혹은 관점과 유사한 매커니즘을
    // 사용해 각 구현 관심사를 분리하여야 한다.

    // 시스템을 설계하든 개별 모듈을 설계하든 실제로 돌아가는 가장 단순한 수단을 사용해야 한다는 사실을 명심이 필요

    public static void main(String[] args) {



    }

}
