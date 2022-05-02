package com.example.blogspringboot.controller;

import com.example.blogspringboot.common.data.TokenData;
import com.example.blogspringboot.common.result.Result;
import com.example.blogspringboot.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Data
    private static class TokenParam {
        private String username;
        private String password;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Result getToken(@RequestBody TokenParam param) {
        String username = param.getUsername();
        String password = param.getPassword();
        String token = userService.getToken(username, password);
        if (token == null) return Result.failed("failed");
        TokenData data = new TokenData();
        data.setToken(token);
        return Result.success(data);
    }
}
