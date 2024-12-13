package com.lj.blog.application.controller.controller.blog.article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BlogArticleController
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/11 21:49
 * @Version JDK 17
 */
@RestController
@RequestMapping("/blog/article")
@Slf4j
public class BlogArticleController {
    /**
     * 获取文章信息
     * */
//    @PostMapping("/getArticles")
//    public Result<PageResponse<ArticleDto>> getArticles(){
//        try {
//
//        }catch (Exception e){
//            log.error("获取文章信息失败:{}", e.getMessage(), e);
//            return Result.error();
//        }
//    }
}
