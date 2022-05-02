package com.example.blogspringboot.mapper;

import com.example.blogspringboot.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface TagMapper {
    void insert(String tag);
    void delete(Long id);
    Tag getOne(String tag);
    ArrayList<Tag> getAll();
}