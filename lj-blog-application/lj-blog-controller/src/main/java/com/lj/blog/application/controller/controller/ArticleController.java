package com.lj.blog.application.controller.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 刘杰
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
