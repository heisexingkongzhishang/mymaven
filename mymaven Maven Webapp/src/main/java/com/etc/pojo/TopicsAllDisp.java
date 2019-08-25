package com.etc.pojo;

import java.util.Date;

import com.etc.entity.Topics;
import com.etc.entity.User;

/**
 * 讨论区界面显示
 * @author asus
 *
 */
public class TopicsAllDisp {
	
	private Topics topics;
	private User reply_lastUser;//最后回帖的用户
	private String reply_lastTime;//帖子最后回复时间
	
	public TopicsAllDisp(){
		
	}

	public TopicsAllDisp(Topics topics, User reply_lastUser, String reply_lastTime) {
		super();
		this.topics = topics;
		this.reply_lastUser = reply_lastUser;
		this.reply_lastTime = reply_lastTime;
	}

	public Topics getTopics() {
		return topics;
	}

	public void setTopics(Topics topics) {
		this.topics = topics;
	}

	public User getReply_lastUser() {
		return reply_lastUser;
	}

	public void setReply_lastUser(User reply_lastUser) {
		this.reply_lastUser = reply_lastUser;
	}

	public String getReply_lastTime() {
		return reply_lastTime;
	}

	public void setReply_lastTime(String reply_lastTime) {
		this.reply_lastTime = reply_lastTime;
	}

	@Override
	public String toString() {
		return "TopicsAllDisp [topics=" + topics + ", reply_lastUser=" + reply_lastUser + ", reply_lastTime="
				+ reply_lastTime + "]";
	}


	
}
