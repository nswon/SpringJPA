package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("api/user")
@Validated
public class ApiController {

    //required = false 는 RequestParam에 값(ex : api?name=(값))이 없어도 동작을 하되, name, age에는 null이 들어감
    @GetMapping("")
    public User get(
            //@Validated 를 통해 Parameter들도 검증을 할 수 있다.
            @Size(min = 2)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        System.out.println(user);
        return user;
    }

    // 특정 controller 에 지정을 해주고 싶을 때는 controller안에 코드적으면 됨
    // 전체 시스템에 예외 처리를 적용시키고 싶을 때는 @RestControllerAdvice annotation을 붙여주면 됨
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
