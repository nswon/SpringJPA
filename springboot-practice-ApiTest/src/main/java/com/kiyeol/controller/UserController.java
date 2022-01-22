package com.kiyeol.controller;

import com.kiyeol.domain.User;
import com.kiyeol.domain.WorkLog;
import com.kiyeol.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //유저 회원가입
    @PostMapping("/user-save")
    public ResponseEntity createUser(@Validated @RequestBody User user){
        User result = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //유저 로그인 (중복 아이디가 있을시 에러 날 수 있음!!!)
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        System.out.print("innder "+user.getId()+"/"+user.getPw() );
        //로그인하기
        return ResponseEntity.ok(userRepository.login(user.getId(),user.getPw()));
    }

    //유저들(포인트,이름)
    @GetMapping("/users")
    public ResponseEntity<List<User>> Users(){
        return ResponseEntity.ok(userRepository.findAll(Sort.by(Sort.Direction.DESC, "point","name")));
    }
    ////
    //특정 유저 찾기1
    @GetMapping("/user/{uid}")
    public ResponseEntity<Optional<User>> getUser1(@PathVariable Long uid){
        System.out.println("getUser1 uid : "+uid);
        System.out.println("getUser1 User : "+userRepository.findById(uid).toString());
        return ResponseEntity.ok(userRepository.findById(uid));
    }
    //특정 유저 찾기2
    @GetMapping("/user")
    public ResponseEntity<Optional<User>> getUser2(@RequestParam Long uid){
        System.out.println("getUser2 uid : "+uid);
        System.out.println("getUser2 User : "+userRepository.findById(uid).toString());

        return ResponseEntity.ok(userRepository.findById(uid));
    }
    ////
    //이름으로 유저찾기
    @GetMapping("/searchUser")
    public ResponseEntity<Optional<User>> searchUser(@RequestParam String name){
        System.out.println("searchUser name : "+name);
        return ResponseEntity.ok(userRepository.searchUser(name));
    }
    //유저 점수 더하기
    @GetMapping("/userScore")
    public ResponseEntity<Optional<User>> UpdateScore(@RequestParam Long uid){
        Optional<User> user = userRepository.findById(uid);
        System.out.println("user : "+user.toString());
        user.ifPresent(selectUser ->{
            selectUser.setPoint(selectUser.getPoint()+100);
            User newUser = userRepository.save(selectUser);
            System.out.println("user: "+newUser);
        });
        System.out.println("user save: "+user.toString());

        return ResponseEntity.ok(userRepository.findById(uid));
    }


}
