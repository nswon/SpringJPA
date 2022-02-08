package com.example.bookmanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data // Getter, Setter, toString 까지 모두 포함
@NoArgsConstructor //인자가 없는 생성자  (ex : 생성자 : public User() {} / method : User user = new User(); )
@AllArgsConstructor //인자가 있는 생성자 (ex : 생성자 : public User(String name) {} / method : User user = new User(name); )
@Builder
@Entity //Jpa에서 관리하는 entity객체임을 정의

/*
Table 뒤에 지정해주는 값은 DB에 영향을 끼침
name을 지정할 수 있음, 지정하지 않으면 entity클래스 이름(User)을 씀
index나 uniqueConstraints같은 제약사항들은 DB에 맡기는게 보편적임, Entity에 표기하지 않는 경우가 더 많음
*/
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {

    @Id //Primary key, id = User 객체의 PK값
    //숫자가 자동으로 증가, strategy = IDENTITY 는 mysql 에서 사용하는 identity 를 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //필드 변수
    @NonNull //
    private String name;

    private String email;

    private LocalDateTime createdAt; //생성시간, 수정시간은 Jpa domain을 만들때 필수로 포함됨

    private LocalDateTime updatedAt;

}
