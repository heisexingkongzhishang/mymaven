package com.etc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.entity.Video;
import com.etc.entity.VideoType;
import com.etc.pojo.PageVideo;
import com.etc.service.AnimationVideoService;
import com.etc.service.impl.AnimationVideoServiceImpl;
import com.etc.tools.PageSupport;

@Controller
public class AnimationPlayVontroller {

	@Resource
	private AnimationVideoService av;
	
/*	private PageSupport ps;
	private PageVideo pv;*/
	
	/**动漫类型控制器*/
	@RequestMapping("/course/show.html")
	@ResponseBody
	private String showAnimationVideo(@RequestParam("video_id") int video_id,HttpServletRequest request)
	{
		System.out.println("12312");
		System.out.println(video_id);
		Video video = new Video();
		request.setAttribute("video", video);
		return "courses/show";
		
	}
	

}
