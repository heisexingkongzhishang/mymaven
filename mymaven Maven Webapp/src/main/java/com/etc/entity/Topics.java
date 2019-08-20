package com.etc.entity;

import java.util.Date;

/** 帖子信息实体类 */
public class Topics {
	
	private Integer topics_id;
	private String topics_title;
	private User topics_User;
	private String topics_context;
	private Integer topics_hits;
	private Integer topics_replys;
	private Date topics_time;
	private Integer topics_isReported;
	private Topictype topics_type;
	
	public Topics(){
		
	}

	public Topics(Integer topics_id, String topics_title, User topics_User, String topics_context, Integer topics_hits,
			Integer topics_replys, Date topics_time, Integer topics_isReported, Topictype topics_type) {
		super();
		this.topics_id = topics_id;
		this.topics_title = topics_title;
		this.topics_User = topics_User;
		this.topics_context = topics_context;
		this.topics_hits = topics_hits;
		this.topics_replys = topics_replys;
		this.topics_time = topics_time;
		this.topics_isReported = topics_isReported;
		this.topics_type = topics_type;
	}

	public Integer getTopics_id() {
		return topics_id;
	}

	public void setTopics_id(Integer topics_id) {
		this.topics_id = topics_id;
	}

	public String getTopics_title() {
		return topics_title;
	}

	public void setTopics_title(String topics_title) {
		this.topics_title = topics_title;
	}

	public User getTopics_User() {
		return topics_User;
	}

	public void setTopics_User(User topics_User) {
		this.topics_User = topics_User;
	}

	public String getTopics_context() {
		return topics_context;
	}

	public void setTopics_context(String topics_context) {
		this.topics_context = topics_context;
	}

	public Integer getTopics_hits() {
		return topics_hits;
	}

	public void setTopics_hits(Integer topics_hits) {
		this.topics_hits = topics_hits;
	}

	public Integer getTopics_replys() {
		return topics_replys;
	}

	public void setTopics_replys(Integer topics_replys) {
		this.topics_replys = topics_replys;
	}

	public Date getTopics_time() {
		return topics_time;
	}

	public void setTopics_time(Date topics_time) {
		this.topics_time = topics_time;
	}

	public Integer getTopics_isReported() {
		return topics_isReported;
	}

	public void setTopics_isReported(Integer topics_isReported) {
		this.topics_isReported = topics_isReported;
	}

	public Topictype getTopics_type() {
		return topics_type;
	}

	public void setTopics_type(Topictype topics_type) {
		this.topics_type = topics_type;
	}

	
	
}
