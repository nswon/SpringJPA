package com.example.bookmanager.controller;

import com.example.bookmanager.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //REST API 요청을 받을 수 있음
public class HelloWorldController {

    @GetMapping("hello-world")
    public String helloWorld() {
        return "hello-world";
    }

    @GetMapping("/user")
    public String user() {
        User user = new User();
        return user.toString();
    }

}
