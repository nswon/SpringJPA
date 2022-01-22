package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {}

    //Timer annotation이 설정된 메서드에서만 로깅
    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode() {}

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for(Object arg : args) { //arg 돌다가
            if(arg instanceof User) { // 내가 원하는 User class와 매칭이 되면
                User user = User.class.cast(arg); //User class로 형변환
                String base64Email = user.getEmail(); //encoding되어있던 email을 꺼냄
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8"); //decoding을 시킴
                user.setEmail(email); //set을 해줌

            }
        }

    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        if(returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(base64Email);
        }

    }
}
