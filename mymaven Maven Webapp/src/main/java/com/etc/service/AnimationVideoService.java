package com.etc.service;

import java.util.List;

import com.etc.entity.Video;
import com.etc.entity.VideoType;
import com.etc.pojo.VideoUpload;
import com.etc.tools.PageSupport;

public interface AnimationVideoService {
	public List<VideoType> showAnimationType();//显示所有动漫类型

	public PageSupport AnimationPage(String fuzzy,Integer currentPageNo, Integer pageSize);//动漫分页导航
	
	public List<Video> AnimationbyPage(String fuzzy,Integer currentPageNo,Integer pageSize);//动漫分页
	
	public Video AnimationVideoById(Integer video_id);//通过video_id查video
	
	public String AnimationVideoUpload(VideoUpload videoupload);//动漫上传
}
