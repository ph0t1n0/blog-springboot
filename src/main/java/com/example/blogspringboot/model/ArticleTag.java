package com.example.blogspringboot.model;

import lombok.Data;

@Data
public class ArticleTag {
    private Long id;
    private Long article_id;
    private String tag;
}
