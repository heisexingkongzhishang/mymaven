package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.entity.User;
import com.etc.service.UserCenterService;

@Controller
public class UserCenterController {
	
	@Resource
	private UserCenterService userCenterService;
	
	/** 进行昵称和性别的更新 
	 * @throws IOException */
	@RequestMapping("/center/update.html")
	public void userUpdate(Integer id,String name,String sex,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(userCenterService.userUpdate(id,name,sex))
		{
			out.print(1);
		}
		else {
			out.print(0);
		}
		out.flush();
		out.close();
	}
	
	@RequestMapping("/center/init")
	@ResponseBody
	public User userQuery(Integer id,HttpServletResponse response) throws IOException
	{
		User user=userCenterService.userQuery(id);
		return user;
	}
	
	@RequestMapping("/mymaven/center/center")
	public String tranfer()
	{
		return "center/center";
	}
	
	@RequestMapping("/center/init")
	public String getNameAndSex()
	{
		return "";
	}
}
