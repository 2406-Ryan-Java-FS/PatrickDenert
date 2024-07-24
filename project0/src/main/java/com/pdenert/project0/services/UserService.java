package com.pdenert.project0.services;

import com.pdenert.project0.models.Game;
import com.pdenert.project0.models.User;

import java.util.List;

public interface UserService {
    public User getUser(String name);
    public User createUser(User user);
    public List<String> getGameByUser(int id);
    public void addGame(int game_id, int user_id);
}
