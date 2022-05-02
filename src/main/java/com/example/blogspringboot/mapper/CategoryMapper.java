package com.example.blogspringboot.mapper;

import com.example.blogspringboot.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface CategoryMapper {
    void insert(String category);
    void delete(Long id);
    Category getOne(String category);
    ArrayList<Category> getAll();
}
