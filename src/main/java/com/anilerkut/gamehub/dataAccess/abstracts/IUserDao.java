package com.anilerkut.gamehub.dataAccess.abstracts;

import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,Integer> {
    User findByMail(String mail);

    User findOneByMailAndPassword(String mail,String password);
}
