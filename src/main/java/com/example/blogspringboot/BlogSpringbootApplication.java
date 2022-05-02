package com.example.blogspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.blogspringboot.mapper")
public class BlogSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogSpringbootApplication.class, args);
	}

}
