package com.example.secondhomework.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//Table "User" is a keyword in postgre,so we can this table create with this way
@Table(name = "\"user\"")
@Getter
@Setter
public class User implements Serializable {
    @SequenceGenerator(name = "generator", sequenceName = "USER_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "SURNAME", nullable = false, length = 50)
    private String surname;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "PHONE", nullable = false, length = 15)
    private String phone;

    @Column(name = "username", nullable = false, length = 20)
    private String username;


}
