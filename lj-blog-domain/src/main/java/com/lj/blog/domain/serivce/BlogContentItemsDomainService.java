package com.lj.blog.domain.serivce;

import com.lj.blog.domain.entity.BlogContentItemsBo;

import java.util.List;

/**
 * @ClassName BlogContentItemsDomainService
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/18 18:51
 * @Version JDK 17
 */
public interface BlogContentItemsDomainService {
    List<BlogContentItemsBo> getAllSentences();
}
