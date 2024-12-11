package com.lj.blog.domain.entity;

import lombok.Data;


/**
 * @ClassName ArticleCategoryBo
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/10 18:01
 * @Version JDK 17
 */
@Data
public class ArticleCategoryBo {
    private Integer id;
    private String categoryName;
    private Integer parentId;
    private Integer level;
    private String categoryDesc;
    private String imageUrl;
    private Integer sortOrder;
}
