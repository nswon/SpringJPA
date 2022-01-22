package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j //log.info 쓰고 싶을 때
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    //https://openapi.naver.com/v1/search/local.json
    // ?query=%EC%A3%BC%EC%8B%9D
    // &display=10
    // &start=1
    // &sort=random

    @GetMapping("/naver")
    public String naver() {
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", "")
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "liWuFMZx2oTd0RwmdvKm")
                .header("X-Naver-Client-Secret", "N1Pd2Q7F48")
                .build();
        String result = restTemplate.getForEntity(uri, String.class);
    }

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(@RequestBody Req<User> user,
                          @PathVariable long userId ,
                          @PathVariable String userName,
                          @RequestHeader("x-authorization") String authorization,
                          @RequestHeader("custom-header") String customHeader) {

        log.info("userId : {}, userName : {}", userId, userName);
        log.info("authorization : {}, customHeader : {}", authorization, customHeader);
        log.info("client req : {}", user);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );

        response.setBody(user.getBody());
        return response;
    }
}
