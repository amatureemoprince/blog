package com.lj.blog.infra.config;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SqlStatementInterceptor
 * @Description SQL 拦截器，用于记录和监控 SQL 语句的执行情况，包含实际参数值
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/13 16:43
 * @Version JDK 17
 */
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class
        })
})
public class SqlStatementInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger("sys-sql");
    // 设置慢查询的阈值（毫秒）
    private static final long SLOW_SQL_THRESHOLD = 2000;

    // ANSI 颜色编码
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        // 开始时间
        long startTime = System.nanoTime();
        try {
            // 执行原方法
            return invocation.proceed();
        } finally {
            // 结束时间
            long endTime = System.nanoTime();
            long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

            // 判断是否为慢查询并应用颜色
            if (duration > SLOW_SQL_THRESHOLD) {
                // 黄色或红色表示慢查询
                String color = duration > SLOW_SQL_THRESHOLD * 2 ? ANSI_RED : ANSI_YELLOW;
                logger.warn("{}慢查询检测:", color);
                logger.warn("方法: {}", methodName);
                logger.warn("执行时间: {} ms", duration);
                logger.warn("========================================" + ANSI_RESET);
            } else {
                // 绿色表示正常查询
                logger.info(ANSI_GREEN + "SQL 执行时间:");
                logger.info("方法: {}", methodName);
                logger.info("执行时间: {} ms", duration);
                logger.info("========================================" + ANSI_RESET);
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
