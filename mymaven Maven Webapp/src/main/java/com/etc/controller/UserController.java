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

	/** Ĭ�Ͻ����¼��ͼ */
	@RequestMapping("/index.html")
	public String index() {
		return "home/index";
	}
	
	@RequestMapping("/question.html")
	public String questionsIndex() {
		return "questions/index";
	}

	/** ��¼������ */
	@RequestMapping("/user/login.html")
	public String login(@RequestParam("user_phone") String user_phone, @RequestParam("user_password") String user_password,
			HttpSession session, HttpServletRequest request) {

		User user = userService.login(user_phone, user_password);
		if (user != null) {// ��¼�ɹ�
			// ���û���Ϣ���浽session
			session.setAttribute(Constants.USER_SESSION, user);
			// ��ת�������̨
			if (user.getUser_name().equals("admin")) {
				return "redirect:/sys/user/main.html";//����Ա�����̨
			}else{
				return "home/index";//��ͨ�û�����ǰ̨
			}

		} else {// ��¼ʧ��
			request.setAttribute("error", "�˺����벻��ȷ��");
			return "home/index";
		}
	}

	/** ����ϵͳ��̨��ҳ */
	@RequestMapping("/sys/user/main.html")
	public String adminLogin() {
		return "admin/default";
	}

}
