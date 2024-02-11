package com.anilerkut.gamehub.business.concretes;

import com.anilerkut.gamehub.business.abstracts.IGameService;
import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.core.utilities.results.Result;
import com.anilerkut.gamehub.core.utilities.results.SuccessDataResult;
import com.anilerkut.gamehub.core.utilities.results.SuccessResult;
import com.anilerkut.gamehub.dataAccess.abstracts.ICommentDao;
import com.anilerkut.gamehub.dataAccess.abstracts.IGameDao;
import com.anilerkut.gamehub.entities.concretes.Comment;
import com.anilerkut.gamehub.entities.concretes.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GameManager implements IGameService {

    private final IGameDao gameDao;

    private final ICommentDao commentDao;

    @Autowired
    public GameManager(IGameDao gameDao, ICommentDao commentDao){
        this.gameDao = gameDao;
        this.commentDao = commentDao;
    }
    @Override
    public DataResult<List<Game>> getAll() {
        return new SuccessDataResult<List<Game>>(gameDao.findAll(),"Games has been listed");
    }

    @Override
    public DataResult<Game> getByName(String gameName) {
        return new SuccessDataResult<Game>(this.gameDao.getByName(gameName));
    }

    @Override
    public DataResult<List<Game>> getByNameStartsWith(String gameName) {
        return new SuccessDataResult<List<Game>>(this.gameDao.getByNameStartsWith(gameName));
    }

    @Override
    public DataResult<List<Game>> getByNameContains(String gameName) {
        return new SuccessDataResult<List<Game>>(this.gameDao.getByNameContains(gameName));
    }

    @Override
    public DataResult<Game> getById(int id) {
        Game game = this.gameDao.findById(id).get();
        Set<Comment> allByGameId = commentDao.findAllByGameId(game.getId());
        game.setComments(allByGameId);
        return new SuccessDataResult<Game>(game);
    }

}
