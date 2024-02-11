package com.anilerkut.gamehub.business.abstracts;

import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.core.utilities.results.Result;
import com.anilerkut.gamehub.entities.concretes.Game;

import java.util.List;

public interface IGameService {
    DataResult<List<Game>> getAll();

    DataResult<Game> getByName(String gameName);

    DataResult<List<Game>> getByNameStartsWith(String gameName);

    DataResult<List<Game>> getByNameContains(String gameName);

    DataResult<Game> getById(int id);

}
