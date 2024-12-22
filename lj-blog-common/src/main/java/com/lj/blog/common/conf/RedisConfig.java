package com.lj.blog.common.conf;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
/**
 * @ClassName RedisConfig
 * @Description redis的配置
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/22 18:12
 * @Version JDK 17
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // 字符串序列化器
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        // JSON序列化器
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(createJsonSerializer());
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(createJsonSerializer());
        template.afterPropertiesSet();
        return template;
    }
    private Jackson2JsonRedisSerializer<Object> createJsonSerializer() {
        ObjectMapper mapper = new ObjectMapper();
        // 配置可见性
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 配置序列化特性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 配置类型信息
        mapper.activateDefaultTyping(
                mapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.NON_FINAL
        );
        return new Jackson2JsonRedisSerializer<>(mapper, Object.class);
    }
}
