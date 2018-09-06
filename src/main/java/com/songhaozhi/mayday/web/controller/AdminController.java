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
public class AdminController {
	@Autowired
    private UserService userService;
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping(value= {"","index"})
	public String index() {
		 return "admin/admin_index";
	}
	/**
	 * 登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpSession session) {
       User user = (User) session.getAttribute("user");
       if (user!=null){
           return "redirect:/admin";
       }
       return "admin/admin_login";
	}
	/**
	 * 验证
	 * @param userName
	 * @param userPwd
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "getLogin")
    @ResponseBody
    public JsonResult getLogin(@RequestParam(value="userName")String userName,@RequestParam(value="userPwd") String userPwd, HttpSession session){
        User user=userService.getByNameAndPwd(userName,userPwd);
        if(user!=null){
            session.setAttribute("user",user);
            return new JsonResult(true,"SUCCESS","登录成功");
        }
        return new JsonResult(false,"ERROR","登录失败");
    }
	/**
	 * 清空session退出
	 * @param session
	 * @return
	 */
	@RequestMapping("/exitLogon")
	public String  exitLogon(HttpSession session) {
		session.invalidate();
		return "admin/admin_login";
	} 
}
