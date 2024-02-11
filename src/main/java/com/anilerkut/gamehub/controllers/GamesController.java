package com.anilerkut.gamehub.controllers;

import com.anilerkut.gamehub.business.abstracts.IGameService;
import com.anilerkut.gamehub.core.utilities.results.DataResult;
import com.anilerkut.gamehub.core.utilities.results.Result;
import com.anilerkut.gamehub.entities.concretes.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/games")
@CrossOrigin
public class GamesController {

    private IGameService gameService;
    @Autowired
    public GamesController(IGameService gameService){
        super();
        this.gameService = gameService;
    }

    @GetMapping("/getall")
    public DataResult<List<Game>> getAll(){
        return this.gameService.getAll();
    }

    @GetMapping("/getByGameName")
    public DataResult<Game> getByName(@RequestParam String gameName){
        return this.gameService.getByName(gameName);
    }

    @GetMapping("/getByGameNameStartsWith")
    public DataResult<List<Game>> getByNameStartsWith(@RequestParam String gameName){
        return this.gameService.getByNameStartsWith(gameName);
    }

    @GetMapping("/getByGameNameContains")
    public DataResult<List<Game>> getByNameContains(@RequestParam String gameName){
        return this.gameService.getByNameContains(gameName);
    }

    @GetMapping("/getByID")
    public DataResult<Game> getById(@RequestParam int gameId){
        return this.gameService.getById(gameId);
    }
}
