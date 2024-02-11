package com.anilerkut.gamehub.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentDto {
    private String review;
    private Integer game_id;
    private Integer user_id;
}
