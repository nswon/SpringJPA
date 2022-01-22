package com.namse.service;


import com.namse.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service // 여기는 Service
@Transactional // 어떤 작업에서 오류가 뜨면 이전에 작업이 성공이었어도 작업을 원상태로 되돌려줌
public class UsersService {

    @Autowired
    UsersRepository usersRepository;
}
