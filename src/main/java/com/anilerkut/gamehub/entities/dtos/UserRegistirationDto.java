package com.anilerkut.gamehub.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistirationDto {
    private String email;
    private String username;
    private String password;
    private String passwordMatch;

}


