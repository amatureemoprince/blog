# 安装vue脚手架
在命令提示符中输入vue --version看有没有版本，没有进行安装则使用下面命令进行安装（前提是有node和npm）
npm install -g @vue/cli@latest
安装后再次使用vue --version验证是否成功安装
然后就可以进行创建项目了。在创建项目的文件夹位置打开cmd，使用
npm create vite@latest ljBlogVue -- --template vue
创建自己想要的名称的vite+vue项目
创建完成后使用
npm install
下载必要的包，再使用（推荐）
npm install vue-router@4 pinia element-plus axios
下载一些组件
就可以使用
npm run dev
启动项目，成功的话，会有一个网址ctrl + 点击  就可以看到在本地启动的项目了
# 基本认知
在main.js中实例Vue项目，可以配置布局配置
```vue
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
// 注册所有图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}
const app = createApp(App)  // 创建 Vue 应用实例
app.use(router)            // 使用路由
app.use(createPinia())     // 使用状态管理
app.use(ElementPlus)       // 使用 UI 组件库
app.mount('#app')          // 挂载到 DOM
```
在App.vue文件中配置项目的基本结构
```vue
<template>
  <div class="app-container">
    <header class="header">这是固定的头部</header>
    <main class="main-content">
      <router-view></router-view>
    </main>
    <footer class="footer">这是固定的底部</footer>
  </div>
</template>

<script setup>
</script>

<style scoped>
.app-container {
  width: 100%;
  min-height: 100vh;
}
.header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 60px;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  z-index: 1000;
  display: flex;
  align-items: center;
  padding: 0 20px;
}

.main-content {
  margin-top: 60px;    /* 与header高度相同 */
  margin-bottom: 60px; /* 与footer高度相同 */
  min-height: calc(100vh - 120px); /* 减去头部和底部的高度 */
  padding: 20px;
}
.footer {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 60px;
  background-color: #fff;
  box-shadow: 0 -2px 4px rgba(0, 0, 0, 0.1);
  z-index: 1000;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
```
可以重写搞一份好看的。router-view中是根据路由加载的页面
今天想了一下，之前并没有系统的学习过前端，所以管理方面的直接去使用开源的若依框架。
现在博客主页已经差不多完成了。准备调用接口
