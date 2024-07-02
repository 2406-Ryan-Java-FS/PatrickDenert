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
    public Game createGame(Game game) {                         //save new game in db
        return gr.save(game);
    }

    @Override
    public Game updateGame(Game game) {                         // update game in db
        return gr.save(game);
    }

    @Override
    public void deleteGame(int id){
        gr.deleteById(id);
    }
}
