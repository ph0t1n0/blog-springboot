package com.example.blogspringboot.service.impl;

import com.example.blogspringboot.model.ArticleWithTags;
import com.example.blogspringboot.common.param.PageParam;
import com.example.blogspringboot.mapper.ArticleMapper;
import com.example.blogspringboot.mapper.ArticleTagMapper;
import com.example.blogspringboot.mapper.CategoryMapper;
import com.example.blogspringboot.mapper.TagMapper;
import com.example.blogspringboot.model.Article;
import com.example.blogspringboot.model.ArticleTag;
import com.example.blogspringboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleTagMapper articleTagMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public boolean save(ArticleWithTags articleWithTags) {
        if (articleWithTags.getArticle().getId() == null) {
            insert(articleWithTags);
        }
        else {
            if (getOne(articleWithTags.getArticle().getId()).getArticle() == null) return false;
            update(articleWithTags);
        }
        return true;
    }

    @Override
    public void insert(ArticleWithTags articleWithTags) {
        articleMapper.insert(articleWithTags.getArticle());
        Long id = articleWithTags.getArticle().getId();
        for (ArticleTag tag : articleWithTags.getTags()) {
            tag.setArticle_id(id);
            articleTagMapper.insert(tag);
            if (tagMapper.getOne(tag.getTag()) == null) {
                tagMapper.insert(tag.getTag());
            }
        }
        if (categoryMapper.getOne(articleWithTags.getArticle().getCategory()) == null) {
            categoryMapper.insert(articleWithTags.getArticle().getCategory());
        }
    }

    @Override
    public void update(ArticleWithTags articleWithTags) {
        articleMapper.update(articleWithTags.getArticle());
        articleTagMapper.delete(articleWithTags.getArticle().getId());
        Long id = articleWithTags.getArticle().getId();
        for (ArticleTag tag : articleWithTags.getTags()) {
            tag.setArticle_id(id);
            articleTagMapper.insert(tag);
            if (tagMapper.getOne(tag.getTag()) == null) {
                tagMapper.insert(tag.getTag());
            }
        }
        if (categoryMapper.getOne(articleWithTags.getArticle().getCategory()) == null) {
            categoryMapper.insert(articleWithTags.getArticle().getCategory());
        }
    }

    @Override
    public void delete(Long article_id) {
        articleTagMapper.delete(article_id);
        articleMapper.delete(article_id);
    }

    @Override
    public ArticleWithTags getOne(Long article_id) {
        ArticleWithTags articleWithTags = new ArticleWithTags();
        articleWithTags.setArticle(articleMapper.getOne(article_id));
        articleWithTags.setTags(articleTagMapper.get(article_id));
        return articleWithTags;
    }

    @Override
    public ArrayList<ArticleWithTags> getAll(PageParam pageParam) {
        ArrayList<Article> articles = articleMapper.getAll(pageParam);
        ArrayList<ArticleWithTags> data = new ArrayList<>();
        for (Article article : articles) {
            ArticleWithTags articleWithTags = new ArticleWithTags();
            articleWithTags.setArticle(article);
            articleWithTags.setTags(articleTagMapper.get(article.getId()));
            data.add(articleWithTags);
        }
        return data;
    }

    @Override
    public ArrayList<ArticleWithTags> getCategory(PageParam pageParam) {
        ArrayList<Article> articles = articleMapper.getCategory(pageParam);
        ArrayList<ArticleWithTags> data = new ArrayList<>();
        for (Article article : articles) {
            ArticleWithTags articleWithTags = new ArticleWithTags();
            articleWithTags.setArticle(article);
            articleWithTags.setTags(articleTagMapper.get(article.getId()));
            data.add(articleWithTags);
        }
        return data;
    }

    @Override
    public ArrayList<ArticleWithTags> getTag(PageParam pageParam) {
        ArrayList<ArticleTag> articleTags = articleTagMapper.getArticleId(pageParam.getTag());
        ArrayList<Long> arrayList = new ArrayList<>();
        for (ArticleTag articleTag: articleTags) {
            arrayList.add(articleTag.getArticle_id());
        }
        pageParam.setId(arrayList);
        ArrayList<Article> articles = articleMapper.getTag(pageParam);
        ArrayList<ArticleWithTags> data = new ArrayList<>();
        for (Article article : articles) {
            ArticleWithTags articleWithTags = new ArticleWithTags();
            articleWithTags.setArticle(article);
            articleWithTags.setTags(articleTagMapper.get(article.getId()));
            data.add(articleWithTags);
        }
        return data;
    }
}
