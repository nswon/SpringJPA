package com.example.customer.controller;

import com.example.customer.dto.Req;
import com.example.customer.dto.UserResponse;
import com.example.customer.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/client")
public class ApiController {

    //client가 server로 요청을 해서 응답을 받는 상태임

    private final RestTemplateService restTemplateService;

    public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }


    @GetMapping("/hello")
    public Req<UserResponse> getHello() {
        return restTemplateService.genericExchange();
    }
}
