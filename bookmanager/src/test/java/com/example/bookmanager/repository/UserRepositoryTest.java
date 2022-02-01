package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //Test 필수 annotation
class UserRepositoryTest {

    @Autowired //의존성 추가
    private UserRepository userRepository;

    @Test
    void crud() {
        //crud : create, read, update, delete

        User user = new User();
        //System.out.println(user.toString());

    }
}