package com.etc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.AnimationVideoMapper;
import com.etc.entity.Video;
import com.etc.entity.VideoType;
import com.etc.pojo.VideoUpload;
import com.etc.service.AnimationVideoService;
import com.etc.tools.PageSupport;


@Transactional
@Service("animationVideoService")
public class AnimationVideoServiceImpl implements AnimationVideoService {
	@Resource
	AnimationVideoMapper avm;
	List<VideoType> listtype = null;
	List<Video> listvideo;
	
	@Override
	public List<VideoType> showAnimationType() {
		// TODO Auto-generated method stub
		try {
			listtype = avm.showAnimationType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listtype;
	}

	@Override
	public List<Video> AnimationbyPage(String fuzzy, Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		try {
			listvideo = avm.AnimationByPage(fuzzy, currentPageNo-1, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listvideo;
	}

	@Override
	public PageSupport AnimationPage(String fuzzy,Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		int totalCount=0;
		try {
			totalCount = avm.AniamtionCountByfuzzy(fuzzy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageSupport ps =new PageSupport();
		ps.setCurrentPageNo(currentPageNo);
		ps.setPageSize(pageSize);
		ps.setTotalCount(totalCount);
		ps.setTotalPageCountByRs();
		return ps;
	}

	@Override
	public Video AnimationVideoById(Integer video_id) {
		// TODO Auto-generated method stub
		Video video = avm.AnimationVideoById(video_id);
		return video;
	}

	@Override
	public String AnimationVideoUpload(VideoUpload videoupload) {
		// TODO Auto-generated method stub
		String str ="上传失败";
		Integer i = avm.AnimationVideoUpload(videoupload);
		if(i>0)
		str="上传成功";
		return str;
	}


}
