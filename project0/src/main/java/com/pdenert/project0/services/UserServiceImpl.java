package com.pdenert.project0.services;

import com.pdenert.project0.models.User;
import com.pdenert.project0.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo ur;

    @Override
    public User getUser(String name){
        User u = ur.findUserByUsername(name);
        return u;
    }
}
