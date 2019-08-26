package com.etc.pojo;

import java.util.List;

import com.etc.entity.Video;
import com.etc.tools.PageSupport;

public class PageVideo {
	//分页导航
	private PageSupport ps;
	
	//当前资源动漫
	private List<Video> list;

	public PageSupport getPs() {
		return ps;
	}

	public void setPs(PageSupport ps) {
		this.ps = ps;
	}

	public List<Video> getList() {
		return list;
	}

	public void setList(List<Video> list) {
		this.list = list;
	}

	public PageVideo(PageSupport ps, List<Video> list) {
		super();
		this.ps = ps;
		this.list = list;
	}

	public PageVideo() {
		super();
	}
	
	
}
