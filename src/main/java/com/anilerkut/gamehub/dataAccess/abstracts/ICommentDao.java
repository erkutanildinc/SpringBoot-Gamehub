package com.anilerkut.gamehub.dataAccess.abstracts;

import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ICommentDao extends JpaRepository<Comment,Integer> {

    Set<Comment> findAllByGameId(int gameId);

}
