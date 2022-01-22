package com.example.customer.service;

import com.example.customer.dto.Req;
import com.example.customer.dto.UserResponse;
import com.example.customer.dto.UserResquest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {
//http://localhost/api/server/hello
    //response

    //server 호출
    public UserResponse hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello") //Path
                .queryParam("name", "aaaa")
                .queryParam("age", 99)
                .encode() //Parameter가 붙을 때
                .build()
                .toUri();
        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();

        //getForEntity 에서 get은 내가 가져오겠다의 get이 아니고, Http의 getmethod이고 Entity로 가져오겠다라는 뜻.
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
        return result.getBody();

    }

    public  UserResponse post() {
        //http://localhost:9090/api/server/user/{userId}/name/{userName}

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve") //순서대로 괄호에 매칭 100 = userId, "steve" = userName
                .toUri();

        System.out.println(uri);

        UserResquest req = new UserResquest();
        req.setName("steve");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();
    }

    public UserResponse exchange() {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();

        UserResquest req = new UserResquest();
        req.setName("steve");
        req.setAge(10);

        RequestEntity<UserResquest> requestEntity = RequestEntity
                .post(uri) // RequestEntity 주소
                .contentType(MediaType.APPLICATION_JSON) //Type은 json으로
                .header("x-authorization", "abcd") //값 넣고싶은거 넣어도 됨
                .header("custom-header", "fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);

        return response.getBody(); //getBody() : 내용을 return
    }

    public Req<UserResponse> genericExchange() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();

        UserResquest userResquest = new UserResquest();
        userResquest.setName("steve");
        userResquest.setAge(10);



        Req<UserResquest> req = new Req();
        req.setHeader(
                new Req.Header()
        );

        req.setResBody(
                userResquest
        );

        RequestEntity<Req<UserResquest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<Req<UserResponse>> response
                = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>(){});
        return response.getBody();
    }
}
