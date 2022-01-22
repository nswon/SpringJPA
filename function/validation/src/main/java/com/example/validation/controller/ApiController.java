package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class ApiController {

    @PostMapping("user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
        //@Valid는 User안에 내가 입력한 annotation을 확인함. 검사하고 싶을 때 씀
        //BindingResult는 바로 페이지 오류(400)을 띄워주는게 아니라 bindingResult안에 값이 들어옴

        if(bindingResult.hasErrors()) { //bindingResult가 에러값을 가지고 있으면
            StringBuilder sb = new StringBuilder(); // builder을 만들어주고
            bindingResult.getAllErrors().forEach(objectError -> { //람다식.. 공부해야겠다
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field : " + field.getField() );
                System.out.println(message);

                sb.append("field : " + field.getField());
                sb.append("message : " + message);

            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        //만약 오류를 발생시키지 않았다면 logic 실행

        return ResponseEntity.ok(user);
    }
}
