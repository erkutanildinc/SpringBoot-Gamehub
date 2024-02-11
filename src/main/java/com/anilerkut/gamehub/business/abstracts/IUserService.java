package com.anilerkut.gamehub.business.abstracts;

import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.core.utilities.results.Result;
import com.anilerkut.gamehub.entities.concretes.Game;
import com.anilerkut.gamehub.entities.concretes.User;
import com.anilerkut.gamehub.entities.dtos.JwtAuthResponse;
import com.anilerkut.gamehub.entities.dtos.UserLoginDto;
import com.anilerkut.gamehub.entities.dtos.UserRegistirationDto;

public interface IUserService {
    Result save(UserRegistirationDto registirationDto);

    JwtAuthResponse login(UserLoginDto userLoginDto);

    DataResult<User> getById(int id);
}
