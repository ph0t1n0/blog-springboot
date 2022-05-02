package com.example.blogspringboot.mapper;

import com.example.blogspringboot.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByUsername(String username);
}
