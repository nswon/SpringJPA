package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller annotation은 String 을 리턴하면 자동으로 리소스를 찾아줌
//Controller page를 내려줄 때 말곤 api를 사용할 땐 RestController를 사용함
@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    //ResponseBody annotation은 리소스를 찾지 않고 ResponseBody를 만들어서 내리겠다라는 뜻
    // 이 방법은 거의 안씀
    @ResponseBody
    @GetMapping("/user")
    public User user() {
        var user = new User();
        user.setName("namse");
        user.setAddress("부산광역시 서구");
        return user;
    }
}
