package com.etc.entity;

import java.util.Date;

public class Topicreply {

	private Integer reply_id;
	private Topics reply_topics;
	private User reply_user;
	private String reply_context;
	private Date reply_time;
	
	public Topicreply(){
		
	}

	public Topicreply(Integer reply_id, Topics reply_topics, User reply_user, String reply_context, Date reply_time) {
		super();
		this.reply_id = reply_id;
		this.reply_topics = reply_topics;
		this.reply_user = reply_user;
		this.reply_context = reply_context;
		this.reply_time = reply_time;
	}

	public Integer getReply_id() {
		return reply_id;
	}

	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}

	public Topics getReply_topics() {
		return reply_topics;
	}

	public void setReply_topics(Topics reply_topics) {
		this.reply_topics = reply_topics;
	}

	public User getReply_user() {
		return reply_user;
	}

	public void setReply_user(User reply_user) {
		this.reply_user = reply_user;
	}

	public String getReply_context() {
		return reply_context;
	}

	public void setReply_context(String reply_context) {
		this.reply_context = reply_context;
	}

	public Date getReply_time() {
		return reply_time;
	}

	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}
	
	
}
