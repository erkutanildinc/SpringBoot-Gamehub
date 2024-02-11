package com.anilerkut.gamehub.dataAccess.abstracts;

import com.anilerkut.gamehub.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDao extends JpaRepository<Category,Integer> {
}
