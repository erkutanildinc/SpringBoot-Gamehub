package com.anilerkut.gamehub.dataAccess.abstracts;

import com.anilerkut.gamehub.entities.concretes.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGameDao extends JpaRepository<Game,Integer> {
    Game getByName(String gameName);

    List<Game> getByNameStartsWith(String gameName);

    List<Game> getByNameContains(String gameName);
    
    /*@Query("Select new com.anilerkut.gamehub.entities.dtos.GameWithCategory(g.gameId,g.name,c.categoryNames) "
            + "From Category c Inner Join c.games g")
    List<GameWithCategory> getGameWithCategoryDetails();
    */


}
