package com.pdenert.project0.controllers;

import com.pdenert.project0.models.Game;
import com.pdenert.project0.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    GameService gs;

    @Autowired
    public GameController(GameService gs) {
        this.gs = gs;
    }

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gs.getAllGames();
    }
}
