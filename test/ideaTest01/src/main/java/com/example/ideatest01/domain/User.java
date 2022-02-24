package com.example.ideatest01.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private int age;

    private String password;

}
