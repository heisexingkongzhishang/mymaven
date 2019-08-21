package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etc.service.UserCenterService;

@Controller
public class UserCenterController {
	
	@Resource
	private UserCenterService userCenterService;
	
	/** 进行昵称和性别的更新 
	 * @throws IOException */
	@RequestMapping("/center/update.html")
	public void userUpdate(String name,String sex,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(userCenterService.userUpdate(9,name,sex))
		{
			out.print("<script language=\"javascript\">alert('更新成功');window.location.href='/mymaven/center/center'</script>");
		}
		else {
			out.print("<script language=\"javascript\">alert('更新成功');window.location.href='/mymaven/center/center'</script>");
		}
		out.flush();
		out.close();
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
