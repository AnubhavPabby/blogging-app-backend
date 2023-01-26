package com.anubhavpabby.blog.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long id;
    @Column(name="user_name", nullable=false, length=150)
    private String name;
    @Column(name="user_dob", nullable=false)
    private LocalDate dob;
    @Column(name="user_email", nullable=false, unique=true)
    private String email;
    @Column(name="user_password", nullable=false)
    private String password;
    @Column(name="user_bio")
    private String bio;
}
