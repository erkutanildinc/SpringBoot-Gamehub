package com.anilerkut.gamehub.business.concretes;

import com.anilerkut.gamehub.business.abstracts.ICategoryService;
import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.core.utilities.results.SuccessDataResult;
import com.anilerkut.gamehub.dataAccess.abstracts.ICategoryDao;
import com.anilerkut.gamehub.dataAccess.abstracts.IGameDao;
import com.anilerkut.gamehub.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryManager implements ICategoryService {

    private ICategoryDao categoryDao;
    @Autowired
    public CategoryManager(ICategoryDao categoryDao){
        super();
        this.categoryDao= categoryDao;
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<List<Category>>(this.categoryDao.findAll(),"Categories has been listed");
    }

    @Override
    public DataResult<Category> getById(int id) {
        return new SuccessDataResult<Category>(this.categoryDao.findById(id).get());
    }
}
