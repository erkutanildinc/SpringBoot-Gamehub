package com.anilerkut.gamehub.controllers;

import com.anilerkut.gamehub.business.abstracts.ICommentService;
import com.anilerkut.gamehub.core.utilities.results.Result;
import com.anilerkut.gamehub.entities.dtos.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentsController {

    private ICommentService commentService;

    @Autowired
    public CommentsController(ICommentService commentService){
        super();
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CommentDto commentDto){
        return this.commentService.add(commentDto);
    }


}
