package com.etc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etc.entity.User;
import com.etc.service.UserService;
import com.etc.tools.Constants;

@Controller
public class UserController {

	@Resource
	private UserService userService;

	/** 默认进入登录视图 */
	@RequestMapping("/index.html")
	public String index() {
		return "login";
	}

	/** 登录控制器 */
	@RequestMapping("/user/login.html")
	public String login(@RequestParam("userCode") String userCode, @RequestParam("userPassword") String userPassword,
			HttpSession session, HttpServletRequest request) {

		User user = userService.login(userCode, userPassword);
		return "courses/index";
/*		if (user != null) {// 登录成功
			// 将用户信息保存到session
			session.setAttribute(Constants.USER_SESSION, user);
			// 跳转到管理后台
			if (user.getUser_name().equals("admin")) {
				return "redirect:/sys/user/main.html";//管理员进入后台
			}else{
				return "home/index";//普通用户进入前台
			}

		} else {// 登录失败
			request.setAttribute("error", "账号密码不正确！");
			return "login";
		}*/
	}

	/** 进入ACG首页 */
	@RequestMapping("ACGHomePage")
	public String ACGHomePage() {
		return "courses/index";
	}
	

	
	/** 进入系统后台首页 */
	@RequestMapping("/sys/user/main.html")
	public String adminLogin() {
		return "admin/default";
	}

}
