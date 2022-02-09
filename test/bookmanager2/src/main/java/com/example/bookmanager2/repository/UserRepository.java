package com.example.bookmanager2.repository;

import com.example.bookmanager2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
