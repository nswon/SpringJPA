package com.example.test07.controller;

import com.example.test07.domain.User;
import com.example.test07.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/main")
    public String write() { return "color/main.html";}

    @GetMapping("/work1")
    public String work1() { return "color/work1.html";}

    @GetMapping("/work2")
    public String work2() { return "color/work2.html";}

    @GetMapping("/work3")
    public String work3() { return "color/work3.html";}

    @GetMapping("/work4")
    public String work4() { return "color/work4.html";}

    @GetMapping("/work5")
    public String work5() { return "color/work5.html";}

    @GetMapping("/work6")
    public String work6() { return "color/work6.html";}

    @GetMapping("/work7")
    public String work7() { return "color/work7.html";}

    @GetMapping("/work8")
    public String work8() { return "color/work8.html";}

    @GetMapping("/work9")
    public String work9() { return "color/work9.html";}

    @GetMapping("/work10")
    public String work10() { return "color/work10.html";}

    @GetMapping("/work11")
    public String work11() { return "color/work11.html";}

    @GetMapping("/work12")
    public String work12() { return "color/work12.html";}



}

