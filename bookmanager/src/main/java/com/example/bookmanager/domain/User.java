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

    @NonNull
    private String email;

    @Column

    /*
    name 속성 :

    Column명을 지정할 수 있음
    만약 @Column(name = "crtdat")라고 지정하면
    어플리케이션에는 가독성을 위해 createdAt 그대로 놔두고
    DB에서 crtdat라고 이름을 사용할 수 있게 된다
    name은 다르지만 서로 맵핑시켜준다.

-------------------------------------------------------------------------

    nullable 속성 :

    nullable = true 가 default값임
    nullable = false로 지정하게 되면 DB에서 not null을 붙여주게 된다.
    ex) create table user {
                        name varchar(255) not null,
                        email varchar(255) not null,
                          }

    nullable을 추가해주는 경우가 많음. null 허용 여부가 logic을 짤 때 중요하기 때문
    */

    private LocalDateTime createdAt; //생성시간, 수정시간은 Jpa domain을 만들때 필수로 포함됨

    private LocalDateTime updatedAt;

    //DB에 반영하지 않고 그냥 사용하고 싶은 속성(객체에서 사용하고 싶은 필드)을 지정해줄 때 사용하는 annotation
    @Transient
    private String testData;

    @Enumerated(value = EnumType.STRING) // 잠재적 오류를 방지하기위함. 매우 중요함
    private Gender gender;

    @PrePersist // insert method 가 실행되기 이전에 실행
    public void prePersist() {
        System.out.println(">>> prePersist");
    }

    @PostPersist // insert method 가 실행된 직후
    public void postPersist() {
        System.out.println(">>> postPersist");
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println(">>> preUpdate");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println(">>> postUpdate");
    }

    @PreRemove
    public void preRemove() {
        System.out.println(">>> preRemove");
    }

    @PostRemove
    public void postRemove() {
        System.out.println(">>> postRemove");
    }

    @PostLoad
    public void postLoad() {
        System.out.println(">>> postLoad");
    }

}
