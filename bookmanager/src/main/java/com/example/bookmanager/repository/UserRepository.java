package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    //JpaRepository 를 상속받음으로써 jpa의 함수(ex : findAll())들을 사용할 수 있다.
    // <> 안에 첫번째로 Entity의 type, 두번째는 PK값의 type

    User findByName(String name); // name을 통해서 User을 가져오는 method를 만듬.

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    User findSomethingByEmail(String email); // entity 자리에 something이 들어와도 정상적으로 작동함

    List<User> findTop1ByName(String name);
    List<User> findFirst1ByName(String name);

    List<User> findLast1ByName(String name);


}
