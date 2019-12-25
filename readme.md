springboot整合swagger

视频地址：https://www.bilibili.com/video/av50333325?p=1
视频资料：https://blog.csdn.net/qq122516902/article/details/89417964

本地swagger访问地址：http://localhost:8080/swagger-ui.html


注意事项：
1、为API配置分组时，路径设置最后需以/**结尾；如：.paths(PathSelectors.ant("/hello/**"))，表示/hello下的所有请求在一个组中
                             