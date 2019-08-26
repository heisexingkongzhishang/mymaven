package com.etc.entity;

public class Video {
	private Integer video_id;
	private String video_name;
	private Integer video_userId;
	private String video_introduce;
	private String video_path;
	private Integer video_hits;
	private Integer video_isReported;
	private Integer video_nums;
	private Integer videotype_id;
	private String video_time;
	public Integer getVideo_id() {
		return video_id;
	}
	public void setVideo_id(Integer video_id) {
		this.video_id = video_id;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public Integer getVideo_userId() {
		return video_userId;
	}
	public void setVideo_userId(Integer video_userId) {
		this.video_userId = video_userId;
	}
	public String getVideo_introduce() {
		return video_introduce;
	}
	public void setVideo_introduce(String video_introduce) {
		this.video_introduce = video_introduce;
	}
	public String getVideo_path() {
		return video_path;
	}
	public void setVideo_path(String video_path) {
		this.video_path = video_path;
	}
	public Integer getVideo_hits() {
		return video_hits;
	}
	public void setVideo_hits(Integer video_hits) {
		this.video_hits = video_hits;
	}
	public Integer getVideo_isReported() {
		return video_isReported;
	}
	public void setVideo_isReported(Integer video_isReported) {
		this.video_isReported = video_isReported;
	}
	public Integer getVideo_nums() {
		return video_nums;
	}
	public void setVideo_nums(Integer video_nums) {
		this.video_nums = video_nums;
	}
	public Integer getvideotype_id() {
		return videotype_id;
	}
	public void setvideotype_id(Integer videotype_id) {
		this.videotype_id = videotype_id;
	}
	public String getVideo_time() {
		return video_time;
	}
	public void setVideo_time(String video_time) {
		this.video_time = video_time;
	}
	public Video(Integer video_id, String video_name, Integer video_userId, String video_introduce, String video_path,
			Integer video_hits, Integer video_isReported, Integer video_nums, Integer videotype_id, String video_time) {
		super();
		this.video_id = video_id;
		this.video_name = video_name;
		this.video_userId = video_userId;
		this.video_introduce = video_introduce;
		this.video_path = video_path;
		this.video_hits = video_hits;
		this.video_isReported = video_isReported;
		this.video_nums = video_nums;
		this.videotype_id = videotype_id;
		this.video_time = video_time;
	}
	public Video() {
		super();
	}
	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", video_name=" + video_name + ", video_userId=" + video_userId
				+ ", video_introduce=" + video_introduce + ", video_path=" + video_path + ", video_hits=" + video_hits
				+ ", video_isReported=" + video_isReported + ", video_nums=" + video_nums + ", videotype_id=" + videotype_id
				+ ", video_time=" + video_time + "]";
	}
	
	
}
