package com.pdenert.project0.controllers;

import com.pdenert.project0.models.Game;
import com.pdenert.project0.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    GameService gs;

    @Autowired
    public GameController(GameService gs) {
        this.gs = gs;
    }

    @GetMapping("/games")
    public List<Game> getAllGames() {                       //return list of all games in db
        return gs.getAllGames();
    }

    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable int id){          //return game with correct id
        // game = gs.getGameById(id);
        //return game.orElseGet(Game::new);
        return gs.getGameById(id);
    }

    @PostMapping("/games")
    public Game createGame(@RequestBody Game game){         //create new game from requestbody
        if (game.getName() == null) {                       //check if name is blank
            return null;
        }
        return gs.createGame(game);                         //save game in db if pass checks
    }

    @PatchMapping("/games/{id}")
    public Game updateGame(@RequestBody Game game, @PathVariable int id){       //update game rating
        Game updatedGame = gs.getGameById(id);                                  //get existing game from db

        if(updatedGame == null){                                                //check if game exists
            return null;
        }

        updatedGame.setRating(game.getRating());                                //update game rating

        return gs.updateGame(updatedGame);                                      //save updates into db
    }

    @DeleteMapping("/games/{id}")
    public int deleteGame(@PathVariable int id){                                //delete game from db
        gs.deleteGame(id);
        return id;                                                              //return id if deleted
    }
}
