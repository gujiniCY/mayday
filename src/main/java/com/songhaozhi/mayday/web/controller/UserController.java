package com.songhaozhi.mayday.web.controller;

import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年8月27日 上午11:15:50
*/
@RequestMapping("/admin")
@Controller
public class UserController {
	@Autowired
    private UserService userService;
	@RequestMapping(value = "/login")
	public String login(HttpSession session) {
       User user = (User) session.getAttribute("user");
       if (user!=null){
           return "admin/admin_index";
       }
       return "admin/admin_login";
	}

	@RequestMapping(value = "getLogin")
    @ResponseBody
    public JsonResult getLogin(String userName, String userPwd, HttpSession session){
        System.out.println(userName+userPwd);
        User user=userService.getByNameAndPwd(userName,userPwd);
        if(user!=null){
            session.setAttribute("user",user);
            return new JsonResult(true,"SUCCESS","登录成功");
        }
        return new JsonResult(true,"ERROR","登录失败");
    }

	

}
