package com.kiyeol.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "worklog")
public class WorkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

//
//
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    User user_id;

    @Column
    double start_latitude;
    @Column
    double start_Longitude;
    @Column
    double desti_latitude;
    @Column
    double desti_Longitude;
}

