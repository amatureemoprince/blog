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

