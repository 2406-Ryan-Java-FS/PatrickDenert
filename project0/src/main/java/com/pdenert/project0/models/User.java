package com.pdenert.project0.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Column(name="user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(name="password")
    private String password;
}
