package com.lj.blog.application.controller.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.alibaba.fastjson.JSON;
import com.lj.blog.application.controller.dto.PutStatusRequest;
import com.lj.blog.common.annotation.SaUserCheckPermission;
import com.lj.blog.common.constant.PermissionConstant;
import com.lj.blog.common.result.Result;
import com.lj.blog.common.satoken.StpKit;
import com.lj.blog.common.utils.LogUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/user/article")
@Tag(name = "用户点赞、收藏控制器")
public class BlogStatusController {
    @PostMapping("/like")
    @SaUserCheckPermission(PermissionConstant.USER_ARTICLE_LIKE)
    public String putLike(@RequestBody PutStatusRequest request){
        try {
            if(log.isInfoEnabled()){
                LogUtils.green("BlogStatusController.putLike:request:" + JSON.toJSONString(request));
            }
            return "点赞成功";
        }catch (Exception e){
           log.error("点赞文章出错：{}", e.getMessage(), e);
           return "点赞失败";
        }
    }

    @PostMapping("/collection")
    @SaCheckPermission(PermissionConstant.USER_COMMENT_PUT)
    public Result<String> putCollection(){
        return null;
    }

    @PostMapping("/comment")
    public Result<String> putComment(){
        return null;
    }
}
