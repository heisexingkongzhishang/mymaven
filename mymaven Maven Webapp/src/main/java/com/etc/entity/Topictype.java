package com.etc.entity;

/** 帖子类型实体类 */
public class Topictype {
	
	private Integer topicType_id;
	private String topicType_name;
	
	public Topictype(){
		
	}

	public Topictype(Integer topicType_id, String topicType_name) {
		super();
		this.topicType_id = topicType_id;
		this.topicType_name = topicType_name;
	}

	public Integer getTopicType_id() {
		return topicType_id;
	}

	public void setTopicType_id(Integer topicType_id) {
		this.topicType_id = topicType_id;
	}

	public String getTopicType_name() {
		return topicType_name;
	}

	public void setTopicType_name(String topicType_name) {
		this.topicType_name = topicType_name;
	}
	
	
	
}
