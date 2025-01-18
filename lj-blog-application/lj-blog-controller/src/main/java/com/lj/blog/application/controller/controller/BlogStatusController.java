package com.lj.blog.application.controller.controller;

import com.alibaba.fastjson.JSON;
import com.lj.blog.application.controller.dto.PutStatusRequest;
import com.lj.blog.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BlogStatusController
 * @Description 博客文章的点赞、评论、收藏功能
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/27 14:19
 * @Version JDK 17
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class BlogStatusController {
    @PostMapping("/like")
    public Result<Integer> putLike(@RequestBody PutStatusRequest request){
        try {
            if(log.isInfoEnabled()){
                log.info("BlogStatusController.putLike:request:{}", JSON.toJSONString(request));
            }
            return null;
        }catch (Exception e){
           log.error("点赞文章出错：{}", e.getMessage(), e);
           return Result.error("点赞文章失败");
        }
    }

    @PostMapping("/collection")
    public Result<String> putCollection(){
        return null;
    }

    @PostMapping("/comment")
    public Result<String> putComment(){
        return null;
    }
}
