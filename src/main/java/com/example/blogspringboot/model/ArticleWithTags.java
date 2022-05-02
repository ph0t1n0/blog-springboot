package com.example.blogspringboot.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ArticleWithTags {
    private Article article;
    private ArrayList<ArticleTag> tags;
}
