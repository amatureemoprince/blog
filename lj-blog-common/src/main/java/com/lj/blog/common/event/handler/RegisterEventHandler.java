package com.lj.blog.common.event.handler;

import com.lj.blog.common.event.RegisterEvent;
import com.lj.blog.common.utils.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName RegisterEventHandler
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/4 7:37
 * @Version JDK 17
 */
@Slf4j
@Async
@Component
public class RegisterEventHandler {

    private final MailUtils mailUtils;

    @Autowired
    public RegisterEventHandler(MailUtils mailUtils) {
        this.mailUtils = mailUtils;
    }

    @EventListener(RegisterEvent.class)
    public void registerEventListener(RegisterEvent registerEvent){
        log.info("监听到用户注册准备发送欢迎邮件");
        String email = registerEvent.getEmail();
        mailUtils.sendRegisterMail(email);
        log.info("发送欢迎注册邮箱结束");
    }

}
