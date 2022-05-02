package com.example.blogspringboot.mapper;

import com.example.blogspringboot.model.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ArticleTagMapper {
    void insert(ArticleTag articleTag);
    void delete(Long article_id);
    ArrayList<ArticleTag> get(Long article_id);
    ArrayList<ArticleTag> getArticleId(String tag);
}
