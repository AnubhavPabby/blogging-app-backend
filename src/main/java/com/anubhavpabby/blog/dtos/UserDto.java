package com.anubhavpabby.blog.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private LocalDate dob;
    private String email;
    private String password;
    private String bio;
}
