package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //JpaRepository 를 상속받음으로써 jpa의 함수(ex : findAll())들을 사용할 수 있다.
    // <> 안에 첫번째로 Entity의 type, 두번째는 PK값의 type
}
