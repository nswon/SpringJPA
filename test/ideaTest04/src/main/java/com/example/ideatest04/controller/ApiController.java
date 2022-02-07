package com.example.ideatest04.controller;

import com.example.ideatest04.domain.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/get")
    public String get(User user) {
        return user.toResultString();
    }
}
