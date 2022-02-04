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

    @Test
    void select() {
        System.out.println(userRepository.findByName("steve"));

        System.out.println("findByEmail :  " + userRepository.findByEmail("steve"));
        System.out.println("getByEmail :  " + userRepository.getByEmail("steve"));
        System.out.println("readByEmail :  " + userRepository.readByEmail("steve"));
        System.out.println("queryByEmail :  " + userRepository.queryByEmail("steve"));
        System.out.println("searchByEmail :  " + userRepository.searchByEmail("steve"));
        System.out.println("streamByEmail :  " + userRepository.streamByEmail("steve"));
        System.out.println("findUserByEmail :  " + userRepository.findUserByEmail("steve"));

        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("steve@gamil.com"));

        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("steve"));
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("steve"));

        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("steve"));
    }
}