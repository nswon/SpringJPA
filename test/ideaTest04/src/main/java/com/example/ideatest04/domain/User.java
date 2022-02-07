package com.example.ideatest04.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

     private String[] word = {"banana", "snack", "info", "apple", "user", "chrome", "data", "domain", "youtube"};

     private double random = Math.floor(Math.random()*(word.length-1));

     private String result = word[(int) random];


     public String toResultString() {
         return result;
     }
}
