## 描述

一个简单的博客 springboot 后端项目。

## 接口

### 获取token

* 请求方法：POST
* 请求地址：/api/v1/token
* 请求数据格式：application/json
* 需要token：否
* 请求体数据格式：
```
{
  "username": "用户名",
  "password": "密码"
}
```
* 获取成功：
```
{
  "code": 200,
  "message": "success",
  "data": {
    "token": "2d08086927f4d87a31154aaf0ba2e067"
  }
}
```
* 获取失败：
```
{
  "code": 400,
  "message": "failed",
  "data": null
}
```

### 保存文章

* 请求方法：POST
* 请求地址：/api/v1/article/save
* 请求数据格式：application/json
* 需要token：是
* 请求体数据格式：
```
{
  "username" : "用户名",
  "token": "token",
  "id": "文章id",
  "category": "分类",
  "title": "标题",
  "body": "正文",
  "tags": [
     "标签数组"
  ]
}
```
* 接口说明：文章id为null时为新增，不为null时为更新，文章标签最多5个。
* 保存成功：
```
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 删除文章

* 请求方法：POST
* 请求地址：/api/v1/article/delete
* 请求数据格式：application/json
* 需要token：是
* 请求体数据格式：
```
{
  "username" : "用户名",
  "token": "token",
  "id": "文章id"
}
```
* 删除成功：
```
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 获取单篇文章

* 请求方法：POST
* 请求地址：/api/v1/article/get
* 请求数据格式：application/json
* 需要token：是
* 请求体数据格式：
```
{
  "username" : "用户名",
  "token": "token",
  "id": "文章id"
}
```
* 获取成功：
```
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "id": 1,
      "category": "Hello world!",
      "create_date": "2022-05-02 08:17:23",
      "update_date": "2022-05-02 08:18:32",
      "title": "Hello world!",
      "body": "Hello world!",
      "tags": [
        "Hello world!",
        "Hello"
      ]
    }
  ]
}
```

### 分页获取全部文章

* 请求方法：POST
* 请求地址：/api/v1/article/all
* 请求数据格式：application/json
* 需要token：是
* 请求体数据格式：
```
{
  "username" : "用户名",
  "token": "token",
  "size": 每页数量,
  "page": 页数（从1开始计算）
}
```
* 获取成功：
```
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "id": 2,
      "category": "Hello springboot!",
      "create_date": "2022-05-02 08:18:21",
      "update_date": "2022-05-02 08:18:21",
      "title": "Hello springboot!",
      "body": "Hello springboot!",
      "tags": [
        "Hello springboot!",
        "Hello"
      ]
    },
    {
      "id": 1,
      "category": "Hello world!",
      "create_date": "2022-05-02 08:17:23",
      "update_date": "2022-05-02 08:18:32",
      "title": "Hello world!",
      "body": "Hello world!",
      "tags": [
        "Hello world!",
        "Hello"
      ]
    }
  ]
}
```

### 分页获取分类文章

* 请求方法：POST
* 请求地址：/api/v1/article/category
* 请求数据格式：application/json
* 需要token：是
* 请求体数据格式：
```
{
  "username" : "用户名",
  "token": "token",
  "size": 每页数量,
  "page": 页数（从1开始计算）
  "category": "分类"
}
```
* 获取成功：
```
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "id": 2,
      "category": "Hello springboot!",
      "create_date": "2022-05-02 08:18:21",
      "update_date": "2022-05-02 08:18:21",
      "title": "Hello springboot!",
      "body": "Hello springboot!",
      "tags": [
        "Hello springboot!",
        "Hello"
      ]
    }
  ]
}
```

### 分页获取标签文章

* 请求方法：POST
* 请求地址：/api/v1/article/tag
* 请求数据格式：application/json
* 需要token：是
* 请求体数据格式：
```
{
  "username" : "用户名",
  "token": "token",
  "size": 每页数量,
  "page": 页数（从1开始计算）
  "tag": "标签"
}
```
* 获取成功：
```
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "id": 2,
      "category": "Hello springboot!",
      "create_date": "2022-05-02 08:18:21",
      "update_date": "2022-05-02 08:18:21",
      "title": "Hello springboot!",
      "body": "Hello springboot!",
      "tags": [
        "Hello springboot!",
        "Hello"
      ]
    },
    {
      "id": 1,
      "category": "Hello world!",
      "create_date": "2022-05-02 08:17:23",
      "update_date": "2022-05-02 08:18:32",
      "title": "Hello world!",
      "body": "Hello world!",
      "tags": [
        "Hello world!",
        "Hello"
      ]
    }
  ]
}
```
