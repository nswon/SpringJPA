package com.namse.controller;

import com.namse.domain.Users;
import com.namse.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // 여기는 controller
public class UsersController {

    @Autowired
    UsersRepository usersRepository; // repository 클래스의 의존성을 가진다

    @GetMapping("/user/{uid}")
    // ResponseEntity는 HTTP(프런트) 응답을 빠르게 만들어주기위한 객체
    // Optional은 값에 null이 들어와도 오류가 안뜨게 해줌. 해석하면 Users타입의 객체를 감싸준다(User객체의 값에 null이 들어와도 오류가 뜨지 않는다)
    // 파라미터로 uid를 long형태로 띄어준다
    public ResponseEntity<Optional<Users>> getUsers (@RequestParam Long uid){
        return ResponseEntity.ok(usersRepository.findById(uid)); // userRepository안에있는 findAll()을 씀(값을 다 띄워줌) ok는 모르겠다
    }
}
