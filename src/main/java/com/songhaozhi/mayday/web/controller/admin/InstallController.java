package com.songhaozhi.mayday.web.controller.admin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.songhaozhi.mayday.model.domain.*;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.LogConstant;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.ArticleStatus;
import com.songhaozhi.mayday.model.enums.PostType;
import com.songhaozhi.mayday.model.enums.ThemeStatus;
import com.songhaozhi.mayday.service.*;
import com.youbenzi.mdtool.tool.MDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 宋浩志
 * @createDate : 2019年1月11日
 */
@Controller
@RequestMapping(value = "/install")
public class InstallController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private OptionsService optionsService;
    @Autowired
    private ThemeService themeService;

    @GetMapping
    public String install(Model model) {
        if (StrUtil.equals("true", MaydayConst.OPTIONS.get("is_install"))) {
            //已注册过
            model.addAttribute("isInstall", true);
        } else {
            //未注册
            model.addAttribute("isInstall", false);
        }
        return "admin/install";
    }

    /**
     * 执行安装
     *
     * @param blogName        博客标题
     * @param blogUrl         博客地址
     * @param emailUsername   电子邮箱
     * @param userName        用户名
     * @param userDisplayName 显示昵称
     * @param nowPwd          登录密码
     * @param confirmPwd      确认密码
     * @return
     */
    @PostMapping(value = "/execute")
    @ResponseBody
    public JsonResult execute(@RequestParam(value = "blogName") String blogName,
                              @RequestParam(value = "blogUrl") String blogUrl,
                              @RequestParam(value = "emailUsername") String emailUsername,
                              @RequestParam(value = "userName") String userName,
                              @RequestParam(value = "userDisplayName") String userDisplayName,
                              @RequestParam(value = "nowPwd") String nowPwd, @RequestParam(value = "confirmPwd") String confirmPwd, HttpServletRequest request) {
        if (!StrUtil.equals(nowPwd, confirmPwd)) {
            return JsonResult.fail("两次密码不一样，请重新输入！");
        }
        //创建用户
        User user = new User();
        user.setUserDisplayName(userDisplayName);
        user.setUserPwd(SecureUtil.md5(confirmPwd));
        user.setUserEmail(emailUsername);
        user.setUserName(userName);
        userService.save(user);

        //保存设置项
        Map<String, String> optionsMap = new HashMap<>();
        optionsMap.put("blog_name", blogName);
        optionsMap.put("blog_url", blogUrl);
        optionsMap.put("email_username", emailUsername);
        optionsMap.put("blog_start", DateUtil.format(DateUtil.date(), "yyyy-MM-dd"));
        optionsMap.put("attachment_location", "server");
        optionsMap.put("is_install", "true");
        optionsService.save(optionsMap);

        //第一篇文章
        Article article = new Article();
        article.setArticleTitle("Hello Mayday!");
        article.setArticleContentMd("# Hello Mayday!\n" +
                "欢迎使用Mayday进行创作，删除这篇文章后赶紧开始吧。");
        article.setArticleContent(MDTool.markdown2Html(article.getArticleContentMd()));
        article.setArticleNewstime(DateUtil.date());
        article.setArticleStatus(ArticleStatus.PUBLISH.getStatus());
        article.setArticleSummary("欢迎使用Mayday进行创作，删除这篇文章后赶紧开始吧。");
        article.setArticleThumbnail("/static/img/rand/" + RandomUtil.randomInt(1, 19) + ".jpg");
        article.setArticleType(ThemeStatus.THEME_NOT_ENABLED.getValue());
        article.setArticlePost(PostType.POST_TYPE_POST.getValue());
        article.setArticleComment(ThemeStatus.THEME_NOT_ENABLED.getValue());
        article.setArticleUpdatetime(DateUtil.date());
        article.setArticleUrl("hello-mayday");
        articleService.insert(article, null, null);

        // 添加日志
        logService.save(new Log(LogConstant.INSTALL_SUCCESS, LogConstant.SUCCESS,
                ServletUtil.getClientIP(request), DateUtil.date()));

        //添加菜单
        Menu menuIndex = new Menu();
        menuIndex.setMenuName("首页");
        menuIndex.setMenuUrl("/");
        menuIndex.setMenuTarget("_self");
        menuIndex.setMenuSort(1);
        menuService.save(menuIndex);
        Menu menuArchives = new Menu();
        menuArchives.setMenuName("归档");
        menuArchives.setMenuUrl("/archives");
        menuArchives.setMenuTarget("_self");
        menuArchives.setMenuSort(2);
        menuService.save(menuArchives);
        Menu menuLinks = new Menu();
        menuLinks.setMenuName("友链");
        menuLinks.setMenuUrl("/links");
        menuLinks.setMenuTarget("_self");
        menuLinks.setMenuSort(3);
        menuService.save(menuLinks);

        //重新加载设置项
        MaydayConst.OPTIONS.clear();
        List<Options> listMap = optionsService.selectMap();
        if (listMap.size() > 0 && !listMap.isEmpty()) {
            for (Options options : listMap) {
                MaydayConst.OPTIONS.put(options.getOptionName(), options.getOptionValue());
            }
        }
        //重置菜单
        MaydayConst.MENUS.clear();
        MaydayConst.MENUS = menuService.findMenus();
        //添加默认主题
        Theme theme = new Theme();
        theme.setThemeName("pinghsu");
        theme.setThemeDescribe("pinghsu");
        theme.setThemeImg("/static/img/pinghsu.jpg");
        theme.setCreateTime(DateUtil.date());
        theme.setThemeStatus(1);
        themeService.saveTheme(theme);
        MaydayConst.THEME_NAME = "pinghsu";
        return JsonResult.ok("注册成功");
    }

}
