package com.anilerkut.gamehub.controllers;

import com.anilerkut.gamehub.business.abstracts.IUserService;
import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.core.utilities.results.Result;
import com.anilerkut.gamehub.entities.concretes.Game;
import com.anilerkut.gamehub.entities.concretes.User;
import com.anilerkut.gamehub.entities.dtos.JwtAuthResponse;
import com.anilerkut.gamehub.entities.dtos.UserLoginDto;
import com.anilerkut.gamehub.entities.dtos.UserRegistirationDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/registiration")
public class AuthController {

    private IUserService userService;

    public AuthController(IUserService userService){
        super();
        this.userService = userService;
    }

    @PostMapping("/register")
    public Result registerAccount(@RequestBody UserRegistirationDto userRegistirationDto){
        return this.userService.save(userRegistirationDto);
    }

    @PostMapping("/login")
    public JwtAuthResponse login(@RequestBody UserLoginDto userLoginDto){
        return this.userService.login(userLoginDto);
    }

    @GetMapping("/getByID")
    public DataResult<User> getById(@RequestParam int userId){
        return this.userService.getById(userId);
    }

}
