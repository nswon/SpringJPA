package com.example.bookmanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data // Getter, Setter, toString 까지 모두 포함
@NoArgsConstructor //인자가 없는 생성자  (ex : 생성자 : public User() {} / method : User user = new User(); )
@AllArgsConstructor //인자가 있는 생성자 (ex : 생성자 : public User(String name) {} / method : User user = new User(name); )
@Builder
@Entity
public class User {

    @Id //Primary key, id = User 객체의 PK값
    @GeneratedValue //숫자가 자동으로 증가
    private long id;

    //필드 변수
    @NonNull //
    private String name;

    private String email;

    private LocalDateTime createdAt; //생성시간, 수정시간은 Jpa domain을 만들때 필수로 포함됨

    private LocalDateTime updatedAt;

}
