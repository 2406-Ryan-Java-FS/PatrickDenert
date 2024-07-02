package com.pdenert.project0.repositories;

import com.pdenert.project0.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    public User findUserByUsername(String username);
}
