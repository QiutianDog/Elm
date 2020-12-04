# Elm_Demo
 饿了么SpringBoot项目模拟

## 配置相关
运行环境
 * jdk 11
 * springboot 2.4.0
 * lombok 1.18.12

yml配置
 * 由于上传文件是到本地目录，
 所以为了成功展示图片需要配置路径映射，
 请将yml文件里面的
 spring.resources.static-locations 
 改成在你电脑下的static包的绝对路径 
 如 file:E:\IdeaProjects\Elm\src\main\resources\static\

## 使用
运行ElmApplication文件。之后打开浏览器访问即可。
以下所有都需要在EmlApplication运行中有效。

* 首页 http://localhost
* 买家入口 http://localhost/buyer/
* 卖家入库 http://localhost/seller/login