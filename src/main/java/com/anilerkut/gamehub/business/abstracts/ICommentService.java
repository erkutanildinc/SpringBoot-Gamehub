package com.anilerkut.gamehub.business.abstracts;

import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.core.utilities.results.Result;
import com.anilerkut.gamehub.entities.concretes.Comment;
import com.anilerkut.gamehub.entities.dtos.CommentDto;

import java.util.List;

public interface ICommentService {

    Result add(CommentDto commentDto);

}
