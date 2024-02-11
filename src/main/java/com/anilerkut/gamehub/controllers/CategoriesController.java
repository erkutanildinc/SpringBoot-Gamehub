package com.anilerkut.gamehub.controllers;

import com.anilerkut.gamehub.business.abstracts.ICategoryService;
import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@CrossOrigin
public class CategoriesController {

    private ICategoryService categoryService;
    @Autowired
    public CategoriesController(ICategoryService categoryService){
        super();
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public DataResult<List<Category>> getAll(){
        return this.categoryService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Category> getById(int id){
        return this.categoryService.getById(id);
    }

}
