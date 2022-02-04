package com.example.ideatest01.controller;

import com.example.ideatest01.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    //get
    @GetMapping("/get")
    public String get() {
        return "hello";
    }

    //RequestBody
    @PostMapping("/post")
    public User post(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    //PathVariable
    @PostMapping("/post/{name}")
    public User name(@RequestBody User user, @PathVariable String name) {
        System.out.println(name);
        return user;
    }


}
