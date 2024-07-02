package com.pdenert.project0.repositories;

import com.pdenert.project0.models.Game;
import com.pdenert.project0.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    public User findUserByUsername(String username);

    @Query(value = "SELECT games.name FROM games " +
            "INNER JOIN owner on games.game_id = owner.game_id " +
            "INNER JOIN users on owner.user_id = users.user_id " +
            "WHERE users.user_id = :id", nativeQuery = true)
    public List<String> getGamesByUser(int id);

    @Query(value = "INSERT INTO owner VALUES (:game_id,:user_id);", nativeQuery = true)
    public void addGameByUser(int game_id, int user_id);
}
