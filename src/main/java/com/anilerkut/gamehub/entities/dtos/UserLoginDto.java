package com.anilerkut.gamehub.entities.dtos;

import lombok.*;

@Data
@AllArgsConstructor
public class UserLoginDto {
    private String email;
    private String password;
}


