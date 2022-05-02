package com.example.blogspringboot.common.data;

import com.example.blogspringboot.model.Article;
import com.example.blogspringboot.model.ArticleTag;
import com.example.blogspringboot.model.ArticleWithTags;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class ArticleData {
    private Long id;
    private String category;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_date;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_date;
    private String title;
    private String body;
    private ArrayList<String> tags;

    public void setFromArticleWithTags(ArticleWithTags articleWithTags) {
        Article article = articleWithTags.getArticle();
        id = article.getId();
        category = article.getCategory();
        create_date = article.getCreate_date();
        update_date = article.getUpdate_date();
        title = article.getTitle();
        body = article.getBody();
        tags = new ArrayList<>();
        for (ArticleTag tag: articleWithTags.getTags()) {
            tags.add(tag.getTag());
        }
    }
}
