package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ApiController {

    //TEXT를 내려줌
    @GetMapping("/text")
    public String text(@RequestParam String account) {

        return account;
    }

    //JSON
    //request -> object mapper -> object -> method -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    //ResponseEntity에다가 HttpStatus code를 명확하게 지정해주고 body에다가 값도 넣어줌
    //이 방법을 제일 선호함
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
