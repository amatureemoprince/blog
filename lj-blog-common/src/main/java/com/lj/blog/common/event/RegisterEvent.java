package com.lj.blog.common.event;

import com.lj.blog.common.utils.MailUtils;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName RegisterEvent
 * @Description 用户注册事件
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/4 7:32
 * @Version JDK 17
 */
@Getter
public class RegisterEvent extends ApplicationEvent {

    private final String email;

    @Autowired
    public RegisterEvent(Object source, String email) {
        super(source);
        this.email = email;
    }

}
