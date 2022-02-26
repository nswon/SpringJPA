package com.example.ideatest01.controller;

import com.example.ideatest01.domain.User;
import org.springframework.http.ResponseEntity;
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
    /*
    db : mysql
    ex :
    {
        "name" : "namse",
        "age" : 17
    }
     */

    @PostMapping("/post/{uid}")
    public User post(@RequestBody User user, @PathVariable Long uid) {
        System.out.println(user);
        System.out.println(uid);
        return user;
    }

    //PathVariable
    @PostMapping("/post/{name}")
    public User name(@RequestBody User user, @PathVariable String name) {
        System.out.println(name);
        return user;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ResponseEntity response) {
        return ResponseEntity.ok(response);
    }

}
