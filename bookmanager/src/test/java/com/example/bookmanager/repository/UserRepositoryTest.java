package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Gender;
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

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("martin");
        user.setEmail("martin@gmail.com");
        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin"); // 수정
        userRepository.save(user2); // 저장

        /*
        findById(1L) : 첫번째 id인 martin을 가져옴
        orElseThrow : 오류를 지정해줌
         */

    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user); // update

        userRepository.findAll().forEach( e -> {
            System.out.println(e);
        });

        System.out.println(userRepository.findRawRecord().get("gender"));

    }
}