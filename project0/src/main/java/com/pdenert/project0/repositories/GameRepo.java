package com.pdenert.project0.repositories;

import com.pdenert.project0.models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends CrudRepository<Game, Integer> {
    public Game findGameByName(String name);
}
