package com.anilerkut.gamehub.dataAccess.abstracts;

import com.anilerkut.gamehub.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
