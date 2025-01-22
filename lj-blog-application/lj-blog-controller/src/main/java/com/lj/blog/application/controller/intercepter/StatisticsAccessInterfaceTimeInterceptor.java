package com.lj.blog.application.controller.intercepter;

import com.alibaba.fastjson.JSON;
import com.lj.blog.common.enums.ColorEnum;
import com.lj.blog.common.utils.LogUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName StatisticsAccessInterfaceTimeInterceptor
 * @Description 设置请求进入的startTime拦截器
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/17 21:23
 * @Version JDK 17
 */
@Slf4j
public class StatisticsAccessInterfaceTimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        String uri = StringUtils.hasText(request.getRequestURI()) ?
                request.getRequestURI() : "未知路径";
        String method = request.getMethod();
        String params = "{}";
        if (!request.getParameterMap().isEmpty()) {
            params = JSON.toJSONString(request.getParameterMap());
        }
        log.info("{}",
                LogUtils.color(">>>> 收到请求 - " +
                        "URI: " +uri+
                        " Method: "+method+
                        " Params: "+params,
                        ColorEnum.CYAN_BRIGHT));
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
