package com.example.blogspringboot.mapper;

import com.example.blogspringboot.common.param.PageParam;
import com.example.blogspringboot.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ArticleMapper {
    void insert(Article article);
    void delete(Long id);
    void update(Article article);
    Article getOne(Long id);
    ArrayList<Article> getAll(PageParam pageParam);
    ArrayList<Article> getCategory(PageParam pageParam);
    ArrayList<Article> getTag(PageParam pageParam);
}
