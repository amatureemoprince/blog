package com.lj.blog.domain.serivce.imp;
import com.alibaba.fastjson.JSON;
import com.lj.blog.common.enums.GlobalEnum;
import com.lj.blog.domain.entity.BlogContentItemsBo;
import com.lj.blog.domain.convert.BlogContentItemBoConvert;
import com.lj.blog.domain.serivce.BlogContentItemsDomainService;
import com.lj.blog.infra.basic.entity.BlogContentItems;
import com.lj.blog.infra.basic.service.impl.BlogContentItemsServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BlogContentItemsDomainServiceImp
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/18 18:52
 * @Version JDK 17
 */
@Service
@Slf4j
public class BlogContentItemsDomainServiceImp implements BlogContentItemsDomainService {
    @Resource
    private BlogContentItemsServiceImpl blogContentItemsService;
    @Resource
    private BlogContentItemBoConvert convert;
    @Override
    public List<BlogContentItemsBo> getAllSentences() {
        List<BlogContentItems> result = blogContentItemsService.queryPrimary(
                BlogContentItems.builder().isDeleted(GlobalEnum.IS_NOT_DELETED.getCode()).build()
        );
        List<BlogContentItemsBo> blogContentItemsBos = convert.blogContentItemToBoList(result);
        if(log.isInfoEnabled()){
            log.info("BlogContentItemsDomainServiceImp.getAllSentences.boList:{}", JSON.toJSONString(blogContentItemsBos));
        }
        return blogContentItemsBos;
    }
}
