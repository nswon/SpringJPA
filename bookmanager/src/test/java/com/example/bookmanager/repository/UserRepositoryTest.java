package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //Test 필수 annotation
class UserRepositoryTest {

    @Autowired //의존성 추가
    private UserRepository userRepository;

    @Test
    void crud() { //crud : create, read, update, delete
        userRepository.save(new User()); //@NoArgsConstructor로 User을 생성. save() : 저장하겠다는 Jpa 함수.

        System.out.println(">>> " + userRepository.findAll()); //User안의 모든 data를 List형식으로 가져오겠다는 Jpa함수

    }
}