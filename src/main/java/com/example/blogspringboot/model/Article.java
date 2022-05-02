package com.example.blogspringboot.model;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Long id;
    private String category;
    private Date create_date;
    private Date update_date;
    private String title;
    private String body;
}
