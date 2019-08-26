package com.etc.dao;

import java.util.List;

import com.etc.entity.Video;
import com.etc.entity.VideoType;
import com.etc.pojo.VideoUpload;
import com.etc.tools.PageSupport;

public interface AnimationVideoMapper {
	public List<VideoType> showAnimationType() throws Exception;//显示所有动漫类型

	public Integer AniamtionCountByfuzzy(String fuzzy) throws Exception;//模糊查询总记录数
	
	public List<Video> AnimationByPage(String fuzzy,Integer currentPageNo,Integer pageSize) throws Exception;//分页

	public Video AnimationVideoById(Integer video_id);//通过video_id查video
	
	public Integer AnimationVideoUpload(VideoUpload videoupload);//动漫上传
}
