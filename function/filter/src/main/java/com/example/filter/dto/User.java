package com.example.filter.dto;

import lombok.*;

//Data는 변수의 get/set method를 만들어주는 annotation
@Data
@NoArgsConstructor //기본생성자
@AllArgsConstructor //전체생성자
public class User {

    private String name;
    private int age;



}
