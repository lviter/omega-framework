# omega-framework

omega快速开发框架
![avatar](static/img/omega-framework架构设计.jpg)

## omega-framework-base

omega-framework基础依赖包版本管理，pom依赖管理

## omega-framework-common

1. 通用请求响应封装
2. 常量池
3. 基础converter
4. 基础pojo
5. ServiceException定义
6. utils工具类封装

## omega-framework-core

1. omega-framework核心依赖包
2. processor前置后置处理器，核心线程管理

## omega-framework-starter

omega框架启动器

### omega-framework-starter-swagger

swagger自动配置启动器

### omega-framework-starter-mybatis-plus

mybatis-plus插件自动配置启动器

### omega-framework-starter-cache

redis/mongo等nosql启动器

### omega-framework-starter-mq

消息队列启动器

## omega-framework-web

1. 针对业务control层提供服务-swagger等
2. ref:omega-framework-starter-swagger

## omega-framework-code-generator

1. ref:omega-framework-starter-mybatis-plus



