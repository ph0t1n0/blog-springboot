package com.example.blogspringboot.service.impl;

import com.example.blogspringboot.mapper.UserMapper;
import com.example.blogspringboot.model.User;
import com.example.blogspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        if (username == null || username.equals("")) return null;
        return userMapper.getUserByUsername(username);
    }

    @Override
    public String getToken(String username, String password) {
        User user = getUserByUsername(username);
        if (user == null || !password.equals(user.getPassword())) return null;
        String str = null;
        try {
            str = DigestUtils.md5DigestAsHex((username + ":" + user.getPassword()).getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public boolean matchToken(String username, String token) {
        User user = getUserByUsername(username);
        if (user == null || token == null || token.equals("")) return false;
        String str = null;
        try {
            str = DigestUtils.md5DigestAsHex((username + ":" + user.getPassword()).getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str == null || str.equals("")) return false;
        return str.equals(token);
    }
}
