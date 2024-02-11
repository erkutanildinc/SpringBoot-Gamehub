package com.anilerkut.gamehub.business.concretes;

import ch.qos.logback.core.CoreConstants;
import com.anilerkut.gamehub.business.abstracts.IUserService;
import com.anilerkut.gamehub.core.utilities.results.*;
import com.anilerkut.gamehub.dataAccess.abstracts.IRoleDao;
import com.anilerkut.gamehub.dataAccess.abstracts.IUserDao;
import com.anilerkut.gamehub.entities.concretes.Game;
import com.anilerkut.gamehub.entities.concretes.Role;
import com.anilerkut.gamehub.entities.concretes.User;
import com.anilerkut.gamehub.entities.dtos.JwtAuthResponse;
import com.anilerkut.gamehub.entities.dtos.UserLoginDto;
import com.anilerkut.gamehub.entities.dtos.UserRegistirationDto;
import com.anilerkut.gamehub.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserManager implements IUserService {

    private IUserDao userDao;

    private final IRoleDao roleDao;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserManager(IUserDao userDao, IRoleDao roleDao, AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, PasswordEncoder passwordEncoder){
        super();
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public Result save(UserRegistirationDto registirationDto) {

        if(!Objects.equals(registirationDto.getPassword(), registirationDto.getPasswordMatch())){
            return new ErrorResult("Passwords Not Match");
        }
        else{
            Role role = roleDao.findByName("USER");
            User user = new User(registirationDto.getUsername(),registirationDto.getEmail(),
                    passwordEncoder.encode(registirationDto.getPassword()), List.of(),new HashSet<>(Collections.singletonList(role)));
            userDao.save(user);
            return new SuccessResult("User has ben added");
        }
    }

    @Override
    public JwtAuthResponse login(UserLoginDto userLoginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginDto.getEmail(),
                userLoginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.generateToken(authentication);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return jwtAuthResponse;
    }

    @Override
    public DataResult<User> getById(int id) {
        Optional<User> optionalUser = this.userDao.findById(id);
        if (optionalUser.isEmpty()){
            return new ErrorDataResult<>("User not found");
        }
        return new SuccessDataResult<User>(optionalUser.get());
    }

}
