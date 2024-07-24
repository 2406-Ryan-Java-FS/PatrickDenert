package com.pdenert.project0.services;

import com.pdenert.project0.models.Game;
import com.pdenert.project0.models.User;
import com.pdenert.project0.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo ur;

    @Override
    public User getUser(String name){
        User u = ur.findUserByUsername(name);
        return u;
    }

    @Override
    public User createUser(User user){
        return ur.save(user);
    }

    @Override
    public List<String> getGameByUser(int id){
        return ur.getGamesByUser(id);
    }

    @Override
    public void addGame(int game_id, int user_id){
        ur.addGameByUser(game_id,user_id);
    }
}
