package com.lj.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 启动类
 */
@SpringBootApplication
@MapperScan("com.lj.**.dao")
public class BlogApplication {
    public static void main(String[] args) {

        SpringApplication.run(BlogApplication.class, args);
    }
}
