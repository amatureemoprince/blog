package com.lj.blog.common.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName AvatarRespDto
 * @Description 上传头像后返回的数据
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/25 9:06
 * @Version JDK 17
 */
@Builder
@Data
public class AvatarRespDto {
    private String url;
    private String folderLocation;
}
