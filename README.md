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


