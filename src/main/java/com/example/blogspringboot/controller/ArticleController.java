package com.example.blogspringboot.controller;

import com.example.blogspringboot.common.data.ArticleData;
import com.example.blogspringboot.common.param.PageParam;
import com.example.blogspringboot.common.result.Result;
import com.example.blogspringboot.model.Article;
import com.example.blogspringboot.model.ArticleTag;
import com.example.blogspringboot.model.ArticleWithTags;
import com.example.blogspringboot.service.ArticleService;
import com.example.blogspringboot.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/article")
public class ArticleController {

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @Data
    private static class SaveParam {
        private String username;
        private String token;
        private Long id;
        private String category;
        private String title;
        private String body;
        private ArrayList<String> tags;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Result save(@RequestBody ArticleController.SaveParam param) {
        if (!userService.matchToken(param.getUsername(), param.getToken())) return Result.failed("failed");
        Article article = new Article();
        article.setId(param.getId());
        article.setCategory(param.getCategory());
        article.setTitle(param.getTitle());
        article.setBody(param.getBody());
        ArrayList<ArticleTag> articleTags = new ArrayList<>();
        for (String tag: param.getTags()) {
            ArticleTag articleTag = new ArticleTag();
            articleTag.setTag(tag);
            articleTags.add(articleTag);
        }
        ArticleWithTags articleWithTags = new ArticleWithTags();
        articleWithTags.setArticle(article);
        articleWithTags.setTags(articleTags);
        boolean success = articleService.save(articleWithTags);
        if (!success) return Result.failed("failed");
        return Result.success();
    }

    @Data
    private static class DeleteParam {
        private String username;
        private String token;
        private Long id;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Result delete(@RequestBody ArticleController.DeleteParam param) {
        if (!userService.matchToken(param.getUsername(), param.getToken())) return Result.failed("failed");
        articleService.delete(param.getId());
        return Result.success();
    }

    @Data
    private static class GetParam {
        private String username;
        private String token;
        private Long id;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Result get(@RequestBody ArticleController.GetParam param) {
        if (!userService.matchToken(param.getUsername(), param.getToken())) return Result.failed("failed");
        ArticleWithTags articleWithTags = articleService.getOne(param.getId());
        if (articleWithTags == null || articleWithTags.getArticle() == null) return Result.failed("failed");
        ArrayList<ArticleData> articleData = new ArrayList<>();
        ArticleData articleData1 = new ArticleData();
        articleData1.setFromArticleWithTags(articleWithTags);
        articleData.add(articleData1);
        if (articleData.isEmpty()) return Result.failed("failed");
        return Result.success(articleData);
    }

    @Data
    private static class AllParam {
        private String username;
        private String token;
        private Long size;
        private Long page;
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Result all(@RequestBody ArticleController.AllParam param) {
        if (!userService.matchToken(param.getUsername(), param.getToken())) return Result.failed("failed");
        PageParam pageParam = new PageParam();
        pageParam.setSize(param.size);
        pageParam.setBegin(param.size * (param.page - 1));
        ArrayList<ArticleWithTags> articleWithTags = articleService.getAll(pageParam);
        if (articleWithTags == null) return Result.failed("failed");
        ArrayList<ArticleData> articleData = new ArrayList<>();
        for (ArticleWithTags articleWithTags1: articleWithTags) {
            ArticleData articleData1 = new ArticleData();
            articleData1.setFromArticleWithTags(articleWithTags1);
            articleData.add(articleData1);
        }
        if (articleData.isEmpty()) return Result.failed("failed");
        return Result.success(articleData);
    }

    @Data
    private static class CategoryParam {
        private String username;
        private String token;
        private Long size;
        private Long page;
        private String category;
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Result category(@RequestBody ArticleController.CategoryParam param) {
        if (!userService.matchToken(param.getUsername(), param.getToken())) return Result.failed("failed");
        PageParam pageParam = new PageParam();
        pageParam.setSize(param.size);
        pageParam.setBegin(param.size * (param.page - 1));
        pageParam.setCategory(param.getCategory());
        ArrayList<ArticleWithTags> articleWithTags = articleService.getCategory(pageParam);
        if (articleWithTags == null) return Result.failed("failed");
        ArrayList<ArticleData> articleData = new ArrayList<>();
        for (ArticleWithTags articleWithTags1: articleWithTags) {
            ArticleData articleData1 = new ArticleData();
            articleData1.setFromArticleWithTags(articleWithTags1);
            articleData.add(articleData1);
        }
        if (articleData.isEmpty()) return Result.failed("failed");
        return Result.success(articleData);
    }

    @Data
    private static class TagParam {
        private String username;
        private String token;
        private Long size;
        private Long page;
        private String tag;
    }

    @RequestMapping(value = "/tag", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Result tag(@RequestBody ArticleController.TagParam param) {
        if (!userService.matchToken(param.getUsername(), param.getToken())) return Result.failed("failed");
        PageParam pageParam = new PageParam();
        pageParam.setSize(param.size);
        pageParam.setBegin(param.size * (param.page - 1));
        pageParam.setTag(param.getTag());
        ArrayList<ArticleWithTags> articleWithTags = articleService.getTag(pageParam);
        if (articleWithTags == null) return Result.failed("failed");
        ArrayList<ArticleData> articleData = new ArrayList<>();
        for (ArticleWithTags articleWithTags1: articleWithTags) {
            ArticleData articleData1 = new ArticleData();
            articleData1.setFromArticleWithTags(articleWithTags1);
            articleData.add(articleData1);
        }
        if (articleData.isEmpty()) return Result.failed("failed");
        return Result.success(articleData);
    }
}
