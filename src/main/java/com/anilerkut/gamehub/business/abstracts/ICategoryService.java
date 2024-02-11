package com.anilerkut.gamehub.business.abstracts;

import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.entities.concretes.Category;

import java.util.List;

public interface ICategoryService {
    DataResult<List<Category>> getAll();

    DataResult<Category> getById(int id);
}
