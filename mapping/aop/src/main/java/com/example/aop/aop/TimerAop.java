package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component //@Bean은 메서드 단위로 annotation을 쓸 수 있고, Component는 클래스 단위
public class TimerAop {

    //대표적인 수식어. 엄청 다양한 수식어가 있다고 함
    //controller 하위에 있는 메서드한테 로깅함
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {}

    //Timer annotation이 설정된 메서드에서만 로깅
    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer() {}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        //실행 전
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();
        //실행 후
        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
