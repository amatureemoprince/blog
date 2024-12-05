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
    api层：
    application层：
    aggressive层：
    domain层：
    infra层：
    starter层：