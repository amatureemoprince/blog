package com.lj.blog.application.controller.controller.article.backend;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lj.blog.application.controller.dto.article.info.AddArticleInfoDto;
import com.lj.blog.common.enums.ArticleModuleEnum;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.serivce.imp.ArticleInfoDomainServiceImp;
import com.lj.blog.infra.basic.entity.ArticleInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author 刘杰
 * TODO：这个都需要重新构建
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleInfoController {

    @Resource
    private ArticleInfoDomainServiceImp articleInfoDomainService;

    /**
     * 增加文章信息，需要将基本信息和文章内容一起传递过来才行
     * TODO：需要进行修改
     * */
    @PostMapping("/add")
    public Result<String> addArticleInfo(@RequestBody AddArticleInfoDto articleInfoDto){
        try {
            if(log.isInfoEnabled()) {
                log.info("ArticleInfoController.addArticleInfo.dto:{}", JSON.toJSONString(articleInfoDto));
            }
            Preconditions.checkNotNull(articleInfoDto.getArticleTitle(), ArticleModuleEnum.ARTICLE_TITLE_NOT_NULL.getMsg());
            Preconditions.checkNotNull(articleInfoDto.getArticleDesc(), ArticleModuleEnum.ARTICLE_DESC_NOT_NULL.getMsg());
            return null;
        }catch (Exception e){
            log.error("");
            return Result.error();
        }
    }
    @PostMapping("/getArticleInfo")
    public Result<ArticleInfo> getArticleInfo(){
       return articleInfoDomainService.getArticleInfo();
    }
}
