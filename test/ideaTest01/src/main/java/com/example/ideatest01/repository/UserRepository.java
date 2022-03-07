package com.example.ideatest01.repository;

import com.example.ideatest01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
