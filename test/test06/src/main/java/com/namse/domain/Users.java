package com.namse.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity // 클래스가 controller라는것을 알려줌
@Getter // 어떤 값을 가져오거나 설정해주는 역할(Setter포함)
@Setter
@AllArgsConstructor // 클래스에 존재하는 모든 필드에 대한 생성자를 생성
@NoArgsConstructor // 파라미터가 없는 생성자를 생성
@Table(name = "user") //table 이름 정해줌
public class Users {
    //기본 키 맵핑작업
    @Id // 이것만 쓰면 직접할당, 밑줄과 같이쓰면 자동할당
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 위임 (즉, id값을 null로 하면 DB가 알아서 auto시켜줌)
    String id;
    String pw;
    String name;
    int score;
}
