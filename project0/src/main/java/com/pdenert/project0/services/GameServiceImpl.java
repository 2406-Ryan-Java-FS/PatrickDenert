package com.pdenert.project0.services;

import com.pdenert.project0.models.Game;
import com.pdenert.project0.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepo gr;

    @Override
    public List<Game> getAllGames() {                           // get all games from db
        return (List<Game>) gr.findAll();
    }

    @Override
    public Game getGameById(int id) {                           // get game from id
        Optional<Game> game = gr.findById(id);
        //return Optional.of(game.orElseGet(Game::new));
        return game.orElseGet(Game::new);                       // unwrap optional
    }

    @Override
<<<<<<< HEAD
=======
    public Game getGameByName(String name){
        return gr.findGameByName(name);
    }

    @Override
>>>>>>> e65732ab0c99ded4ae269fd1f481ff0248108c70
    public Game createGame(Game game) {                         //save new game in db
        return gr.save(game);
    }

    @Override
    public Game updateGame(Game game) {                         // update game in db
        return gr.save(game);
    }
<<<<<<< HEAD
=======

    @Override
    public void deleteGame(int id){
        gr.deleteById(id);
    }
>>>>>>> e65732ab0c99ded4ae269fd1f481ff0248108c70
}
