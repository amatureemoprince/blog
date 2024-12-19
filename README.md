# 关于本项目
在学校中的aip实训中学习到了许多之前在学校老师那没有感受到的实操知识。更多的是关于实现了一个功能
之后的成就感，可以激励着自己去实现更复杂更有趣的功能。于是就买了一台云服务器准备搭建一个自己的博客。
关于这整个项目的搭建，代码的架构，以及使用到的技术（更多的是学习用，并不是纯属搭建）， 都会写在这个
readme文件中。

* [不仅要有梦想还要有远方]()

# 项目结构
* [传统项目结构]()
基于dao、service、controller的三层架构。是非常容易理解的，也是最基础的架构。形如一条链，不断的
向下调用。在一般业务中是可以这样的，但是如果业务中存在许多的嵌套调用，就会非常麻烦，且如果业务需要
变化在dao修改了代码，与之有关的service层代码几乎都需要重写，十分的不便。
* [已有的架构]()
采用ddd架构实现：
    api层：对外提供接口，可以为第三方提供jar包调用服务。保证纯洁性，req、resp、接口；
    application层：应用层，熟知的controller层，还有job、mq；
    aggressive层：聚合层，可以将跨模块的业务功能进行聚合；
    domain层：领域层，具有在领域内的原子性服务；
    infra层：基础设施层，负责各种基础功能。包括和数据库、缓存等进行交互；
    starter层：启动层，只负责启动项目。

**采用终端的业务是不需要聚合层的，因为只用提供单一的服务。只有跨模块的业务才需要该层。**

# maven项目的管理
## 父项目管理整体的依赖版本
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.lj</groupId>
    <artifactId>Blog</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>pom</packaging>
    <name>Blog</name>
    <description>手搓一个自己的博客</description>
    <url/>
    <modules>
        <module>lj-blog-api</module>
        <module>lj-blog-application</module>
        <module>lj-blog-common</module>
        <module>lj-blog-domain</module>
        <module>lj-blog-infra</module>
        <module>lj-blog-starter</module>
    </modules>
    <!--管理依赖版本-->
    <properties>
        <java.version>17</java.version>
        <spring-boot.version>3.3.5</spring-boot.version>
        <spring-boot-web.version>3.3.5</spring-boot-web.version>
        <druid-spring-boot-starter.version>1.2.16</druid-spring-boot-starter.version>
        <mysql-connector-java.version>8.0.33</mysql-connector-java.version>
        <mybatis-plus.version>3.5.7</mybatis-plus.version>
    </properties>
    <!--父模块的依赖管理：使用dependencyManagement是因为不用让每个子模块都加在所有的依赖，根据自己需要引入就行-->
    <dependencyManagement>
        <dependencies>
            <!--注入springboot依赖-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!--引入druid连接池-->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid-spring-boot-starter</artifactId>
                <version>${druid-spring-boot-starter.version}</version>
            </dependency>
            <!--mysql-->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql-connector-java.version}</version>
            </dependency>
            <!--mybatis-plus-->
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-spring-boot3-starter</artifactId>
                <version>${mybatis-plus.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <!--配置阿里云仓库-->
    <repositories>
        <repository>
            <id>central</id>
            <name>aliyun maven</name>
            <url>https://maven.aliyun.com/nexus/content/groups/public/</url>
            <layout>default</layout>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
</project>
```
在父pom文件中，我们定义了依赖版本，并引入了springboot的依赖，以及引入了mysql和mybatis-plus的依赖。
然后子模块中需要什么依赖直接引用不需要版本号了。具体例子如上。

## 子模块管理依赖版本
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.lj</groupId>
        <artifactId>Blog</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <artifactId>lj-blog-starter</artifactId>
    <name>lj-blog-starter</name>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>com.lj</groupId>
            <artifactId>lj-blog-controller</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
```
用的starter层的pom依赖，不用赘言，比较清楚的结构。

# 数据库设计
## 博客文章模块
### 数据库设计（第一张数据库表详细一点，后面的不是主要的字段就跟第一张表同理）
关于文章模块的设计的数据库表有：
* [article_info]()：包含文章的基本信息
  - id ：文章信息主键
  - article_title ：文章标题
  - article_desc ：文章描述
  - article_top ：文章是否置顶 默认为0（无需置顶）
  - article_image ：文章展示的图片
  - article_status ：文章的编辑状态 默认为1（已通过）
  - create_time ：文章创建时间（数据库中默认创建时间）
  - update_time ：文章更新时间（数据中默认更新时间）
  - is_deleted ：文章逻辑删除（默认为0，1是已删除）
* [article_content]()：文章的内容
  - id
  - article_id ：文章id
  - article_content ：文章的md格式内容
  - article_html ：文章的html格式内容
  - create_time
  - update_time
  - is_deleted
* [article_comment]()：文章评论表
  - id ：评论主键id
  - article_id ：文章id
  - user_id ：用户id
  - comment_comment ：评论内容
  - parent_id ：父级评论id（默认null）
  - reply_user_id ：回复的用户id（默认null）
  - root_id ：根评论id（默认null）
  - like_count ：评论的点赞数（默认0）
  - status ：评论的审核（默认1通过）
  - create_time 
  - update_time
  - is_deleted
* [article_status]()：文章统计表
  - article_id ：文章id，同时也是主键
  - view_count ：浏览数量（默认0，下面的也是）
  - like_count ：点赞数量
  - comment_count ：评论数量
  - collection_count ：收藏数量
  - share_count ：分享数量
  - update_time
* [article_like]()：用户点赞表
  - id
  - article_id ：文章id
  - user_id ：用户id
  - create_time
  - is_deleted
* [article_collection]()：用户收藏表
  - id
  - article_id ：文章id
  - user_id ：用户id
  - create_time
  - is_deleted
* [article_category]()：文章分类类型表
  - id
  - category_name ：分类名称
  - parent_id ：父级分类id
  - category_desc ：分类的描述
  - sort_order ：排序规则（默认0）
  - create_time
  - update_time
  - is_deleted
* [article_category_rel]()：文章分类关联表
  - id
  - article_id ：文章id
  - category_id ：分类id
  - create_time 
  - is_deleted
* [article_tag]()：文章标签表
  - id
  - tag_name ：标签名称
  - tag_desc ：标签描述
  - create_time 
  - update_time
  - is_deleted
* [article_tag_rel]()：文章标签关联表
  - id
  - article_id ：文章id
  - tag_id ：标签id
  - create_time
  - is_deleted

**目前就先这样设计**：一个浏览我发出的博客内容功能和一些交互功能。2024-12-9先实现基本得增删改查功能吧！
# 输出控制台的数据格式
## 使用log4j2
不使用SpringBoot自带的logback，一是因为logback的性能不如log4j2；而是log4j2的配置和扩展性更好。
具体的需要引入log4j2的依赖，并将logback排除，这样才能启动项目，不然会因为兼容问题出错。
然后在application.yml文件中配置
```yml
logging:
  config: classpath:log4j2-spring.xml
```
后面的是配置文件的位置跟application同级
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--
Configuration后面的status用于设置log4j2自身内部的信息输出，可以不设置。
当设置成trace时，你会看到log4j2内部各种详细输出。
monitorInterval：Log4j能够自动检测修改配置文件和重新配置本身，设置间隔秒数(最小是5秒钟)
-->
<configuration monitorInterval="5" status="warn">
    <!-- 日志级别以及优先级排序: OFF > FATAL > ERROR > WARN > INFO > DEBUG > TRACE > ALL -->

    <!-- 变量配置 -->
    <Properties>
        <!--
        格式化输出：
        %d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度
        %msg：日志消息，%n是换行符
        %highlight{}用于根据日志级别自动添加颜色
        -->
        <property name="LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss,SSS} %highlight{%-5level} [%t] %highlight{%c{1.}.%M(%L)}: %msg%n" />

        <!-- 定义日志存储的路径 -->
        <property name="FILE_PATH" value="log" />
        <property name="FILE_NAME" value="ljBlog" />
    </Properties>

    <!-- 此节点有三种常见的子节点：Console, RollingFile, File -->
    <appenders>
        <!-- console节点用来定义输出到控制台的Appender -->
        <console name="Console" target="SYSTEM_OUT">
            <!-- 输出日志的格式 -->
            <PatternLayout pattern="${LOG_PATTERN}"/>
            <!-- 阈值过滤器，控制台只输出level及其以上级别的信息（onMatch），其他的直接拒绝（onMismatch） -->
            <ThresholdFilter level="info" onMatch="ACCEPT" onMismatch="DENY"/>
        </console>

        <!--
        这个会打印出所有的debug及以下级别的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档
        -->
        <RollingFile name="RollingFileDebug" fileName="${FILE_PATH}/${FILE_NAME}-debug.log" filePattern="${FILE_PATH}/debug/DEBUG-%d{yyyy-MM-dd}_%i.log.gz">
            <ThresholdFilter level="debug" onMatch="ACCEPT" onMismatch="DENY"/>
            <PatternLayout pattern="${LOG_PATTERN}"/>
            <Policies>
                <!-- 指定滚动日志的策略 -->
                <TimeBasedTriggeringPolicy interval="1" modulate="true" />
                <SizeBasedTriggeringPolicy size="100MB"/>
            </Policies>
            <DefaultRolloverStrategy max="15">
                <!-- 删除15天之前的日志 -->
                <Delete basePath="${FILE_PATH}" maxDepth="2">
                    <IfFileName glob="*/*.log.gz" />
                    <IfLastModified age="360H" />
                </Delete>
            </DefaultRolloverStrategy>
        </RollingFile>

        <!--
        这个会打印出所有的info及以下级别的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档
        -->
        <RollingFile name="RollingFileInfo" fileName="${FILE_PATH}/${FILE_NAME}-info.log" filePattern="${FILE_PATH}/info/INFO-%d{yyyy-MM-dd}_%i.log.gz">
            <ThresholdFilter level="info" onMatch="ACCEPT" onMismatch="DENY"/>
            <PatternLayout pattern="${LOG_PATTERN}"/>
            <Policies>
                <TimeBasedTriggeringPolicy interval="1" modulate="true" />
                <SizeBasedTriggeringPolicy size="100MB"/>
            </Policies>
            <DefaultRolloverStrategy max="15"/>
        </RollingFile>

        <!--
        这个会打印出所有的error及以下级别的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档
        -->
        <RollingFile name="RollingFileError" fileName="${FILE_PATH}/${FILE_NAME}-error.log" filePattern="${FILE_PATH}/error/ERROR-%d{yyyy-MM-dd}_%i.log.gz">
            <ThresholdFilter level="error" onMatch="ACCEPT" onMismatch="DENY"/>
            <PatternLayout pattern="${LOG_PATTERN}"/>
            <Policies>
                <TimeBasedTriggeringPolicy interval="1" modulate="true" />
                <SizeBasedTriggeringPolicy size="100MB"/>
            </Policies>
            <DefaultRolloverStrategy max="15"/>
        </RollingFile>

        <!-- 启用异步日志，阻塞队列最大容量为20000 -->
        <Async name="Async" bufferSize="20000" blocking="true">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="RollingFileDebug"/>
            <AppenderRef ref="RollingFileInfo"/>
            <AppenderRef ref="RollingFileError"/>
        </Async>
    </appenders>

    <!-- Logger节点用来单独指定日志的形式，比如要为指定包下的class指定不同的日志级别等 -->
    <loggers>
        <!-- 过滤掉spring和mybatis的一些无用的DEBUG信息 -->
        <logger name="org.mybatis" level="info" additivity="false">
            <AppenderRef ref="Async"/>
        </logger>

        <!-- 设置 MyBatis-Plus 包的日志级别为 ERROR -->
        <Logger name="com.baomidou.mybatisplus" level="error" additivity="false">
            <AppenderRef ref="Console"/>
        </Logger>

        <!-- 监控系统信息 -->
        <Logger name="org.springframework" level="info" additivity="false">
            <AppenderRef ref="Async"/>
        </Logger>

        <!-- root 节点用来指定项目的根日志 -->
        <root level="debug">
            <AppenderRef ref="Async" />
        </root>
    </loggers>
</configuration>
```
这个是一个基础的配置文件
## sql语句的输出
在项目开发中难免会出现bug，在排查过程中少不了去看sql语句，虽然可以直接在application.yml文件中配置mybatis的输出格式
但是输出的参数是带有?这个的，不会有具体的值，值在后面，一旦参数多了，根本看不过来，所以使用实现接口的形式来进行替换。
这样在输出时就是带有具体值的sql语句了，而且可以将sql语句和执行的时间进行输出和改变为易于发现的颜色。这样的实现就合理多了。
```java
package com.lj.blog.infra.config;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
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
    public static final Logger logger = LoggerFactory.getLogger("sys-sql");

    // ANSI 颜色编码
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[93m";

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
            logger.info("参数 = {}", parameter);
            String sqlId = ms.getId();
            logger.info("调用方法 = {}", sqlId);
            Configuration configuration = ms.getConfiguration();
            String sql = getSql(configuration, boundSql, sqlId);
            logger.info(ANSI_YELLOW + "使用的完整的SQL:\n{}", sql + ANSI_RESET);
        } catch (Exception e) {
            logger.error("异常:{}", e.getLocalizedMessage(), e);
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
                .replaceAll("\\s+", " ") // 去除多余空格
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
```
```java
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
```
```java
package com.lj.blog.infra.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @ClassName MybatisConfiguration
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/13 17:21
 * @Version JDK 17
 */
@Configuration
public class MybatisConfiguration {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new MybatisPlusAllSqlLog());
        return mybatisPlusInterceptor;
    }
}
```
实现这三个类就可以实现详细且带有颜色的sql语句输出了，在调试时真的是非常好用。
```java
package com.lj.blog.application.controller.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @ClassName GlobalConfig
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/14 9:55
 * @Version JDK 17
 */
@Configuration
public class GlobalConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(@NonNull List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(mappingJackson2HttpMessageConverter());
    }
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
}
```
配置消息转换器，防止空对象转json报错和null值不返回（没有用的数据拦截了）
