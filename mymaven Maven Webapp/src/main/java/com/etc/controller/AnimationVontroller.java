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
public class AnimationVontroller {

	@Resource
	private AnimationVideoService av;
	private List<VideoType> listtype;
	private List<Video> listvideo;
/*	private PageSupport ps;
	private PageVideo pv;*/
	
	/**动漫类型控制器*/
	@RequestMapping("/course/index.html")
	@ResponseBody
	private List<VideoType> showAnimationVideo(HttpServletRequest request)
	{
		System.out.println("12312");
		listtype = av.showAnimationType();
		System.out.println(listtype.size());
		return listtype;
		
	}
	
	/** 转入动漫播放页面 */
	@RequestMapping("/courses/toshow.html")
	public String toAniamtionShow(@RequestParam("video_id") int video_id,HttpServletRequest request) {
		//通过video_id查video
		Video video = av.AnimationVideoById(video_id);
		request.setAttribute("video", video);
		return "courses/show";
	}
	
	/** 转入动漫上传页面 */
	@RequestMapping("/courses/uploadvideo.html")
	public String toUploadVideo(HttpServletRequest request) {
		
		return "courses/uploadvideo";
	}
	
	
	/**动漫视频分页控制器*/
	@RequestMapping("/fenye/")
	@ResponseBody
	private PageVideo AnimationVideoByPage(@RequestParam("fuzzy") String fuzzy,@RequestParam("currentPageNo") String currentPageNo,@RequestParam("pageSize") String pageSize,HttpServletRequest request)
	{
	/*	try {
			fuzzy = new String(fuzzy.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(fuzzy==null)
		{
			System.out.println("con");
		}
		if(currentPageNo==null||currentPageNo.equals(""))
		{
			currentPageNo="1";
		}
		if(pageSize==null||pageSize.equals(""))
		{
			pageSize="15";
		}
		System.out.println("6666");
		
		System.out.println("1:"+fuzzy+" 2:"+currentPageNo+" 3:"+pageSize);
		int currentPageNo1=Integer.parseInt(currentPageNo);
		int pageSize1=Integer.parseInt(pageSize);
		listvideo=av.AnimationbyPage(fuzzy, currentPageNo1, pageSize1);
		PageSupport ps =new PageSupport();
		PageVideo pv=new PageVideo();
		System.out.println(pageSize1);
		ps=av.AnimationPage(fuzzy, currentPageNo1, pageSize1);
		System.out.println();
		pv.setList(listvideo);
		pv.setPs(ps);
		request.setAttribute("pv", pv);
		return pv;
		
	}
}
