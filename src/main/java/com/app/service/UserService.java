package com.app.service;

import java.util.List;

import com.app.model.User;

public interface UserService {
	
    User saveUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();
}
