
<h1><a href="https://mayday.songhaozhi.com">mayday</a></h1>

# 本项目完全是出于学习与交流的目的，如果你看不上本项目请直接右上角，不要在评论区留下装逼的话，当然，我非常欢迎友善的评论与建议

>mayday博客系统是我想边学习springboot和thymeleaf编写的一个java博客系统

> 取名mayday可能是因为我是五月天的假粉丝吧！

> 博客基本功能都已实现，后续还会一直更新下去！

![JDK](https://img.shields.io/badge/jdk-1.8-green.svg?style=flat-square) [![LICENSE](https://img.shields.io/github/license/gujiniCY/mayday.svg?style=flat-square)](https://github.com/gujiniCY/mayday/blob/master/LICENSE)   [![star](https://img.shields.io/github/stars/gujiniCY/mayday.svg?label=Stars&style=social)](https://github.com/gujiniCY/mayday)[![star](https://gitee.com/song_haozhi/mayday/badge/star.svg?theme=white)](https://gitee.com/song_haozhi/mayday) 

## 快速开始
`git clone https://github.com/gujiniCY/mayday.git`

下载代码以后，运行sql文件夹下的sql文件，并且到src/main/resources下的application.yaml下修改你的数据库链接
保存好以后 mvn package打包运行 进入target文件夹运行java -jar mayday.jar

如果使用又拍云cdn的话请到参数跟随里面设置全程跟随以及开启重定向跟随

### 关于评论功能
目前没有打算自己写评论功能，于是用的[valine](https://ioliu.cn/2017/add-valine-comments-to-your-blog/)评论系统
valine基本功能都已实现，查看[教程](https://valine.js.org/)部署好以后到博客后台设置APP ID和APP KEY保存以后就可以了
### 关于主题
这两天有人在后台新增主题并设置启用，然后就首页就500了，我现在只做了一个主题，所以在后台新增主题启用是没有任何用的，主题模块我以后应该会改掉，目前就先这样吧 :relieved: 
## 图片演示
![install.png](https://images.gitee.com/uploads/images/2019/0117/112452_b81fbb50_1574192.png)
![login.png](https://images.gitee.com/uploads/images/2019/0117/112450_7ae99bba_1574192.png)
![admin.png](https://images.gitee.com/uploads/images/2019/0117/112450_3a600852_1574192.png)
![post.png](https://images.gitee.com/uploads/images/2019/0117/112451_d6754471_1574192.png)
![profile.png](https://images.gitee.com/uploads/images/2019/0117/112451_499f580f_1574192.png)
![theme.png](https://images.gitee.com/uploads/images/2019/0117/112451_a4e0016a_1574192.png)
![tag.png](https://images.gitee.com/uploads/images/2019/0117/112451_05569d9b_1574192.png)
![upload_attach.png](https://images.gitee.com/uploads/images/2019/0117/112451_50127984_1574192.png)
![attach.png](https://images.gitee.com/uploads/images/2019/0117/112451_66bac3bf_1574192.png)
![write_post.png](https://images.gitee.com/uploads/images/2019/0117/112454_1b3d8fa9_1574192.png)
![menu.png](https://images.gitee.com/uploads/images/2019/0117/112452_58ac3c2d_1574192.png)
![link.png](https://images.gitee.com/uploads/images/2019/0117/112452_ecf27d79_1574192.png)
![new_page.png](https://images.gitee.com/uploads/images/2019/0117/112455_e9bdbee6_1574192.png)
![option.png](https://images.gitee.com/uploads/images/2019/0117/112452_c40d529a_1574192.png)
![page.png](https://images.gitee.com/uploads/images/2019/0117/112452_6c1d4dd7_1574192.png)
![category.png](https://images.gitee.com/uploads/images/2019/0117/112452_0e35930e_1574192.png)
![index.png](https://images.gitee.com/uploads/images/2019/0117/112455_a6973f29_1574192.png)
![index_archives.png](https://images.gitee.com/uploads/images/2019/0117/112453_cc8c9773_1574192.png)

![index_links.png](https://images.gitee.com/uploads/images/2019/0117/112453_1208a83f_1574192.png)
![index_post.png](https://images.gitee.com/uploads/images/2019/0117/112454_327abed1_1574192.png)
## 开源协议
[MIT](https://gitee.com/song_haozhi/mayday/blob/master/LICENSE)
## 致谢：
 1. [springboot](http://spring.io/projects/spring-boot) 版本2.0.4
 2. [mybatis](http://www.mybatis.org/mybatis-3/) ORM框架
 3. [mysql](https://www.mysql.com/) 数据库，版本5.6
 4. [maven](http://maven.apache.org/)  依赖管理
 5. [druid](https://github.com/alibaba/druid/) 阿里连接池
 6. [thymeleaf](https://www.thymeleaf.org/) spring官方推荐的模板引擎
 7. [Vali Admin](https://github.com/pratikborsadiya/vali-admin) 后台模板
 8. [jquery toast插件](http://www.jqueryfuns.com/resource/2412) 信息提示插件
 9. [fontawesome](http://www.fontawesome.com.cn/faicons/) 图标库
 10. [thumbnailator](https://github.com/coobird/thumbnailator) 压缩图片工具类
 11. [hutool](http://hutool.mydoc.io/) Hutool是一个Java工具包
 12. [pagehelper](https://pagehelper.github.io/) mybatis分页插件
 13. [bootstrap-fileinput](https://github.com/kartik-v/bootstrap-fileinput) bootstrap上传控件
 14. [halo](https://github.com/ruibaby/halo)  halo博客系统
 15. [ehcache](http://www.ehcache.org/) Java的进程内缓存框架
 16. [MDTool](https://github.com/cevin15/MDTool) 将markdown转换为html的工具



