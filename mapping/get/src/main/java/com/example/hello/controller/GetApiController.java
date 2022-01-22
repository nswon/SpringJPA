package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.apache.catalina.startup.UserConfig;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // controller 클래스라는것을 알려줌
@RequestMapping("/api/get") // 초기 url : localhost:8080/api/get
public class GetApiController {

    //변화하는 data의 값을 받으면 계속해서 GetMapping을 복사할 순 없기 때문에 @PathVariable 을 사용한다.
    //변화하는 url 주소 부분에 {받는 data}를 적어준다. @PathVariable 로 받아준다.

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable : " + name);
        return name;
    }

    // GetMapping 에 적힌 name과 String 변수 name과 이름이 동일해야한다.
    //만약 동일하게 할 수 없는 상황일 때,

    /*    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        return pathName;
    }  */
    // 이런 식으로 해주면 된다.


    //query-param?key=value&key2=value2 이런식으로 받는 방식이다.
    //람다식이랑 Map에 대해서 공부하고 와야겠다.. 무슨말인지 모르겠다.
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry-> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+ "=" + entry.getValue() + "\n");
        });
        return sb.toString();
    }

    //Map으로 받는 경우에는 key값을 모른다.
    //다른 방법
    //문제점 : 지금은 key의 값이 3개뿐이지만, 늘어나면 계속 추가해줘야한다는 단점
    @GetMapping("/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        return name+" "+email+" "+age;
    }

    //마지막 방법, 이 방법을 가장 추천한다고 하고 가장 많이 쓰인다고 한다.
    //dto package를 따로 만들어준다.
    //가장 큰 차이점은 @RequestParam을 사용하지않고 객체를 정의한 다음 사용한다.

    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest) {

        return userRequest.toString();
    }


}
