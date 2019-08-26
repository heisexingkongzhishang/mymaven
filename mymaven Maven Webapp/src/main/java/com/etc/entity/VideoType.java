package com.etc.entity;

public class VideoType {
	private Integer videoType_id;
	private String videoType_name;
	public Integer getVideoType_id() {
		return videoType_id;
	}
	public void setVideoType_id(Integer videoType_id) {
		this.videoType_id = videoType_id;
	}
	public String getVideoType_name() {
		return videoType_name;
	}
	public void setVideoType_name(String videoType_name) {
		this.videoType_name = videoType_name;
	}
	public VideoType(Integer videoType_id, String videoType_name) {
		super();
		this.videoType_id = videoType_id;
		this.videoType_name = videoType_name;
	}
	public VideoType() {
		super();
	}
	@Override
	public String toString() {
		return "VideoType [videoType_id=" + videoType_id + ", videoType_name=" + videoType_name + "]";
	}
	
	
}
