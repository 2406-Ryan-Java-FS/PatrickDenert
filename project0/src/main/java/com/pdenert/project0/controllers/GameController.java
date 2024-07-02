package com.pdenert.project0.controllers;

import com.pdenert.project0.models.Game;
import com.pdenert.project0.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Game>> getAllGames() {                       //return list of all games in db
        return ResponseEntity.status(200).body(gs.getAllGames());
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable int id){          //return game with correct id
        // game = gs.getGameById(id);
        //return game.orElseGet(Game::new);
        return ResponseEntity.status(200).body(gs.getGameById(id));
    }

    @PostMapping("/games")
    public ResponseEntity<Game> createGame(@RequestBody Game game){         //create new game from requestbody
        if (game.getName() == null) {                                       //check if name is blank
            return null;
        }
        return  ResponseEntity.status(200).body(gs.createGame(game));       //save game in db if pass checks
    }

    @PatchMapping("/games/{id}")
    public ResponseEntity<Game> updateGame(@RequestBody Game game, @PathVariable int id){       //update game rating
        Game updatedGame = gs.getGameById(id);                                  //get existing game from db

        if(updatedGame == null){                                                //check if game exists
            return null;
        }

        updatedGame.setRating(game.getRating());                                //update game rating

        return ResponseEntity.status(200).body(gs.updateGame(updatedGame));     //save updates into db
    }

    @DeleteMapping("/games/{id}")
    public ResponseEntity<Integer> deleteGame(@PathVariable int id){            //delete game from db
        gs.deleteGame(id);
        return ResponseEntity.status(200).body(id);                             //return id if deleted
    }
}
