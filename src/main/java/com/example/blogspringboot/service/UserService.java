package com.example.blogspringboot.service;

import com.example.blogspringboot.model.User;

public interface UserService {
    User getUserByUsername(String username);
    String getToken(String username, String password);
    boolean matchToken(String username, String token);
}
