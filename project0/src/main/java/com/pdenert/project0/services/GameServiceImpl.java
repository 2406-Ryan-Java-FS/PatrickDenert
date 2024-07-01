package com.pdenert.project0.services;

import com.pdenert.project0.models.Game;
import com.pdenert.project0.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepo gr;

    @Override
    public List<Game> getAllGames() {
        return (List<Game>) gr.findAll();
    }
}
