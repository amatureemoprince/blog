package com.lj.blog.common.publish;

import com.lj.blog.common.event.RegisterEvent;
import com.lj.blog.common.exception.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @ClassName Publisher
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/4 7:49
 * @Version JDK 17
 */
@Slf4j
@Component
public class Publisher {

    private final ApplicationEventPublisher publisher;

    @Autowired
    public Publisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void registerUserPublisher(String email) {
        try {
            RegisterEvent registerEvent = new RegisterEvent(this, email);
            publisher.publishEvent(registerEvent);
            log.info("注册事件发布成功");
        } catch (Exception e) {
            log.error("注册事件发布失败: {}", e.getMessage(), e);
            throw new BusinessException("发送欢迎注册邮箱失败");
        }
    }
}
