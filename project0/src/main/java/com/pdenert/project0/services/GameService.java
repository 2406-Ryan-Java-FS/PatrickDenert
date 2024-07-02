package com.pdenert.project0.services;

import com.pdenert.project0.models.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    public List<Game> getAllGames();
    public Game getGameById(int id);
    public Game createGame(Game game);
    public Game updateGame(Game game);
    public void deleteGame(int id);
}
