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
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty()){       // return 400 error if user does not give username or password
            return ResponseEntity.status(400).body(null);
        } else if(us.getUser(user.getUsername()) != null){
            return ResponseEntity.status(409).body(null);                               //return conflict errror is username is taken
        } else {
            User u = us.createUser(user);
            return ResponseEntity.status(200).body(u);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User u = us.getUser(user.getUsername());

        if(u==null){
            return ResponseEntity.status(401).body(null);                               //return unauth if user not exist
        } else if(!u.getPassword().equals(user.getPassword())){
            return ResponseEntity.status(401).body(null);                               //return unauth if password incorrect
        } else{
            return ResponseEntity.status(200).body(u);                                  //return user from db if auth pass
        }


    }
}
