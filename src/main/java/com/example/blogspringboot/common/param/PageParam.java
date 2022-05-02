package com.example.blogspringboot.common.param;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PageParam {
    private Long begin;
    private Long size;
    private String category;
    private String tag;
    private ArrayList<Long> id;
}
