package com.anilerkut.gamehub.business.concretes;

import com.anilerkut.gamehub.business.abstracts.ICommentService;
import com.anilerkut.gamehub.core.utilities.results.*;
import com.anilerkut.gamehub.dataAccess.abstracts.ICommentDao;
import com.anilerkut.gamehub.dataAccess.abstracts.IGameDao;
import com.anilerkut.gamehub.dataAccess.abstracts.IUserDao;
import com.anilerkut.gamehub.entities.concretes.Comment;
import com.anilerkut.gamehub.entities.concretes.Game;
import com.anilerkut.gamehub.entities.concretes.User;
import com.anilerkut.gamehub.entities.dtos.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
@Service
public class CommentManager implements ICommentService {

    private ICommentDao commentDao;
    private IGameDao gameDao;
    private IUserDao userDao;

    @Autowired
    public CommentManager(ICommentDao commentDao,IGameDao gameDao,IUserDao userDao){
        super();
        this.commentDao = commentDao;
        this.gameDao = gameDao;
        this.userDao = userDao;
    }

    @Override
    public Result add(CommentDto commentDto) {
        Integer gameId = commentDto.getGame_id();
        Integer userId = commentDto.getUser_id();
        System.out.println(commentDto.getReview());
        if(gameId == null || userId == null){
            return new ErrorResult("Cant found gameId or userId");
        }
        Game commentsGame = gameDao.findById(gameId).get();
        if(commentsGame != null){
            User commentsUser = userDao.findById(userId).get();
            if(commentsUser != null){
                Date currentDate = new Date();
                LocalDate date = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Comment comment = new Comment();
                comment.setGame(commentsGame);
                comment.setUser(commentsUser);
                comment.setReview(commentDto.getReview());
                comment.setCreatedDate(date);
                commentDao.save(comment);
                return new SuccessResult("Comment has ben added");
            }
            else{
                return new ErrorResult("User not found");
            }
        }
        else {
            return new ErrorResult("Game not found");
        }
    }
}
