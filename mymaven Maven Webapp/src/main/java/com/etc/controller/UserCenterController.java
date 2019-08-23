package com.etc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping("/center/init.html")
	@ResponseBody
	public User userQuery(Integer id,HttpServletResponse response) throws IOException
	{
		System.out.println("id:"+id);
		User user=userCenterService.userQuery(id);
		return user;
	}
	
	@RequestMapping("/mymaven/center/center")
	public String tranfer()
	{
		return "center/center";
	}
	
	@RequestMapping(value="/uploadPic.html",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,@RequestParam(value = "myfile", required = false) MultipartFile myfile)
	{
		String myFilePath = null;// 文件保存到数据库的路径
		if (!myfile.isEmpty()) {// 图片有上传
			// 读取uploads的真实路径
			String path = request.getSession().getServletContext().getRealPath("WEB-INF" + File.separator + "jsp" + File.separator + "center" +File.separator + "pic");
			System.out.println("path:" + path);
			// 读取原文件名
			String oldFileName = myfile.getOriginalFilename();
			System.out.println("原文件名:" + oldFileName);
			// 读取文件扩展名
			String extName = FilenameUtils.getExtension(oldFileName);
			System.out.println("扩展名:" + extName);
			int fileSize = 5000000;// 文件大小5M
			// 读取文件大小
			System.out.println("文件大小:" + myfile.getSize());

			if (myfile.getSize() > fileSize) {// 文件超过限定
				request.setAttribute("uploadFileError", "*上传文件超过5M!");
				return "error";
			} else if (extName.equalsIgnoreCase("jpg") || extName.equalsIgnoreCase("png")
					|| extName.equalsIgnoreCase("jpeg") || extName.equalsIgnoreCase("pneg")) {// 扩展名是否合法
				// 重命名文件
				String fileName = System.currentTimeMillis() + "_user." + extName;
				System.out.println("新文件名:" + fileName);
				// 创建文件对象,接收从客户端已经传到服务器的文件流
				File targetFile = new File(path, fileName);

				try {
					myfile.transferTo(targetFile); // 保存文件
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				String id=request.getParameter("id");
				Integer user_id=Integer.parseInt(id);
				if(userCenterService.userPicUpdate(user_id, fileName)>0)
				{
					System.out.println("更新图片成功");
				}
				
			} else {
				request.setAttribute("uploadFileError", "*上传文件格式不正确!");
				return "error";
			}

		}
		return "center/center";
	};
	
}
