package com.example.bookmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.internal.LoadingCache;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(value = MyEntityListener.class)
public class Book implements Auditable{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /*
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    */
}
