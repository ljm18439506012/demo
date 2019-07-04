package com.lijm.demo.jpatest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "persion")
public class Persion {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;
}
