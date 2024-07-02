package com.pdenert.project0.services;

import com.pdenert.project0.models.User;

public interface UserService {
    public User getUser(String name);
    public User createUser(User user);
}
