package com.lj.blog.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName AspectLog
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/7 16:27
 * @Version JDK 17
 */
@Component
@Slf4j
@Aspect
public class AspectLog {

    @Pointcut("@annotation(com.lj.blog.common.annotation.AspectLog)")
    public void log(){
    }

    @Around(value = "log() && @annotation(aspectLog)", argNames = "pjp,aspectLog")
    public Object aspectLog(ProceedingJoinPoint pjp, com.lj.blog.common.annotation.AspectLog aspectLog) throws Throwable {
        Object result;
        log.info(aspectLog.pre());
        result = pjp.proceed();
        log.info(aspectLog.later());
        return result;
    }
}
