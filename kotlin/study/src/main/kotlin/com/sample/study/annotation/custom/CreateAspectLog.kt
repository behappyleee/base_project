package com.sample.study.annotation.custom

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
// @Aspect 를 사용 하려면 @EnableAspectAutoProxy 를 스프링 설정에 추가해주어야 하지만, 스프링 부트를 사용하면
// 자동으로 추가를 해준다 !
@Aspect // AOP 를 구현할 것들을 모아놓은 클래스라는 @Aspect 라는 어노테이션으로 표시, 이 안에 횡단 관심사를 구현 해 줌
class CreateAspectLog {

    // Cross Cutting Concerns
    // 여러 Layer 에서 공통적으로 해결해야 하는 문제
    // 부가 기능은 Layer 에 횡단으로 걸쳐 적용 하여야 함

    private val logger = LoggerFactory.getLogger(CreateAspectLog::class.java)

    // This aspect annotated with @Aspect and @Component. The @Around
    // annotation is used to specify the advice that should be executed around methods
    // annotated with @LogCustomAnnotation It logs the execution time before and after the method invocation.

    // @LogCustomAnnotation : When this method is invoked, the aspect will intercept the call and
    // log the execution time.

    @Around("@annotation(LogCustomAnnotation)")
    // Paramter 로 joinPoint 어떻게 넘겨 주는 지 ... ? 음 .... ?
    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any? {
        val start = System.currentTimeMillis()
        println("LogCustomAnnotation START TIME : $start")

        // val result = joinPoint.proceed()
        val result = joinPoint.proceed()

        val duration = System.currentTimeMillis() - start
        println("[THIS IS TRANSACTIONAL LOG TIME CHECK !! TIME DURATION ] : " + duration)

        // logger.debug("[THIS IS TRANSACTIONAL LOG TIME CHECK !! TIME DURATION ] : {} ", duration)
        return result
    }

}