package com.kiyeol.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    long uid;
    @Column
    String id;
    @Column
    String pw;
    @Column
    String name;
    @Column
    int point;
    @Column
    int ticket;

    @OneToMany(mappedBy="user_id")
    @JsonIgnore
    private List<WorkLog> workLogList = new ArrayList<WorkLog>();

    @OneToMany(mappedBy="user_id")
    @JsonIgnore
    private List<Report> reportList = new ArrayList<Report>();
}

