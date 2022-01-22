package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //Aop로 동작하기 위한 annotation
@Component // Spring에서 관리해줌
public class ParameterAop {

    //method 이름이 꼭 cut이 아니어도 됨. 아무이름이나 상관없음. @annotation이 제일 중요함
    @Pointcut("execution(* com.example.aop.controller..*.*(..))") //대표적인 수식어. 엄청 다양한 수식어가 있다고 함
    private void cut() {}

    //JoinPoint : 들어가는 지점에 대한 정보가 담겨있는 객체
    //@Before("cut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs(); //매개변수들의 배열

        for(Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    //@AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("returnObj");
        System.out.println(returnObj);
    }

}
