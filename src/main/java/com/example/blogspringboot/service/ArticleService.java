package com.example.blogspringboot.service;

import com.example.blogspringboot.common.param.PageParam;
import com.example.blogspringboot.model.ArticleWithTags;

import java.util.ArrayList;

public interface ArticleService {
    boolean save(ArticleWithTags articleWithTags);
    void insert(ArticleWithTags articleWithTags);
    void update(ArticleWithTags articleWithTags);
    void delete(Long article_id);
    ArticleWithTags getOne(Long article_id);
    ArrayList<ArticleWithTags> getAll(PageParam pageParam);
    ArrayList<ArticleWithTags> getCategory(PageParam pageParam);
    ArrayList<ArticleWithTags> getTag(PageParam pageParam);
}
