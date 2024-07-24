package com.pdenert.project0.controllers;

import com.pdenert.project0.models.Game;
<<<<<<< HEAD
import com.pdenert.project0.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.pdenert.project0.models.User;
import com.pdenert.project0.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
>>>>>>> e65732ab0c99ded4ae269fd1f481ff0248108c70
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
<<<<<<< HEAD
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
=======
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
        if (game.getName().isEmpty()) {                                     //check if name is blank
            return ResponseEntity.status(400).body(null);                   //return bad request if name is blank
        } else if(gs.getGameByName(game.getName()) != null){
            return ResponseEntity.status(409).body(null);
        } else{
            return  ResponseEntity.status(200).body(gs.createGame(game));       //save game in db if pass checks
        }

    }

    @PatchMapping("/games/{id}")
    public ResponseEntity<Game> updateGame(@RequestBody Game game, @PathVariable int id) {       //update game rating
        Game updatedGame = gs.getGameById(id);                                  //get existing game from db

        if (updatedGame.getName()==null) {
            return ResponseEntity.status(400).body(null);                       //return bad request if game doesnt exist
        } else if (!updatedGame.getName().equals(game.getName())) {
            return ResponseEntity.status(409).body(null);                       //return conflict if editing wrong game
        } else {
            updatedGame.setRating(game.getRating());                                //update game rating
            return ResponseEntity.status(200).body(gs.updateGame(updatedGame));     //save updates into db
        }
    }


    @DeleteMapping("/games/{id}")
    public ResponseEntity<Integer> deleteGame(@PathVariable int id){            //delete game from db
        Game deletedGame = gs.getGameById(id);                                  //check if id exists in db

        if(deletedGame.getGame_id() == null){
            return ResponseEntity.status(400).body(null);                       //return bad req if game doesnt exist
        }

        gs.deleteGame(id);
        return ResponseEntity.status(204).body(null);                             //return no content if succesful
    }

>>>>>>> e65732ab0c99ded4ae269fd1f481ff0248108c70
}
