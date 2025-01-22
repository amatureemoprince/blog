package com.lj.blog.common.conf;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MinioConfig
 * @Description Minio配置类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/22 21:20
 * @Version JDK 17
 */
@Data
@Configuration
public class MinioConfig {

    /**
     * 访问地址
     */
    @Value("${minio.endpoint}")
    private String endpoint;

    /**
     * accessKey类似于用户ID，用于唯一标识你的账户
     */
    @Value("${minio.accessKey}")
    private String accessKey;

    /**
     * secretKey是你账户的密码
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * 默认存储桶
     */
    @Value("${minio.bucketName}")
    private String bucketName;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

}
