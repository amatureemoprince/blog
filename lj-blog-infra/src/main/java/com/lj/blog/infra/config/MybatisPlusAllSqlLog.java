package com.lj.blog.infra.config;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.lj.blog.common.utils.LogUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;

/**
 * @ClassName MybatisPlusAllSqlLog
 * @Description MyBatis Plus SQL 日志拦截器
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/13 16:58
 * @Version JDK 17
 */
public class MybatisPlusAllSqlLog implements InnerInterceptor {
    public static final Logger logger = LoggerFactory.getLogger("BLOG-SYSTEM-SQL");

    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter,
                            RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        logInfo(boundSql, ms, parameter);
    }

    @Override
    public void beforeUpdate(Executor executor, MappedStatement ms, Object parameter) throws SQLException {
        BoundSql boundSql = ms.getBoundSql(parameter);
        logInfo(boundSql, ms, parameter);
    }

    private static void logInfo(BoundSql boundSql, MappedStatement ms, Object parameter) {
        try {
            logger.info("{}", LogUtil.yellow(">>>> 参数 = " + parameter));
            String sqlId = ms.getId();
            logger.info("{}", LogUtil.yellow(">>>> 调用方法 = " + sqlId));
            Configuration configuration = ms.getConfiguration();
            String sql = getSql(configuration, boundSql, sqlId);
            logger.info("{}", LogUtil.yellow(">>>> 使用的完整的SQL:\n" + sql));
        } catch (Exception e) {
            logger.error(">>>> 异常:{}", e.getLocalizedMessage(), e);
        }
    }

    private static String getSql(Configuration configuration, BoundSql boundSql, String sqlId) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (!CollectionUtils.isEmpty(parameterMappings) && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sqlId.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(parameterObject)));
            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql.getAdditionalParameter(propertyName);
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else {
                        sql = sql.replaceFirst("\\?", "缺失");
                    }
                }
            }
        }
        return formatSql(sql);
    }

    private static String formatSql(String sql) {
        // 在这里添加换行和缩进以提高可读性
        return sql.replaceAll("(?i)(select|from|where|and|or|join|on|group by|order by|limit)", "\n$1")
                .replaceAll("\\s+", " ")
                .trim(); // 去掉首尾空格
    }

    private static String getParameterValue(Object obj) {
        String value;
        if (obj instanceof String) {
            value = "'" + obj + "'";
        } else if (obj instanceof Date) {
            DateFormat format = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + format.format(new Date()) + "'";
        } else {
            value = (obj != null) ? obj.toString() : "NULL";
        }
        return value;
    }
}
