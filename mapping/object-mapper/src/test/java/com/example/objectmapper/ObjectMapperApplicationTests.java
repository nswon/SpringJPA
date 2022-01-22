package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {

        System.out.println("---------------------");

        var objectMapper = new ObjectMapper();

        //object -> text JSON
        //object mapper가 get method를 활용한다.

        var user = new User("namse", 17, "010-1111-2222");

        var text = objectMapper.writeValueAsString(user); //value -> string
        System.out.println(text);

        //text -> object
        //object mapper는 default 생성자를 필요로 한다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
