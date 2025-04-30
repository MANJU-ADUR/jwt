package com.jwt.entity;

import com.jwt.utils.TimeStamps;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User extends TimeStamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
}
