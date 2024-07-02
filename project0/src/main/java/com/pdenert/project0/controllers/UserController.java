package com.pdenert.project0.controllers;

import com.pdenert.project0.models.User;
import com.pdenert.project0.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService us;

    @Autowired
    public UserController(UserService us){
        this.us = us;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User u = us.createUser(user);
        return ResponseEntity.status(200).body(u);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User u = us.getUser(user.getUsername());

        if(u==null){
            return null;
        }

        return ResponseEntity.status(200).body(u);
    }
}
