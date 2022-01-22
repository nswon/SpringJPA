package com.namse.controller;

import com.namse.domain.User;
import com.namse.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/holysheet")
    public ResponseEntity<List<User>> Users() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
