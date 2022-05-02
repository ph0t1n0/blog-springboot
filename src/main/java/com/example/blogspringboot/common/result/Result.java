package com.example.blogspringboot.common.result;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result success() {
        Result result = new Result(200, "success");
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result(200, "success");
        result.setData(data);
        return result;
    }

    public static Result failed(String message) {
        Result result = new Result(400, message);
        return result;
    }
}
