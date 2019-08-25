package com.etc.dao;

import java.util.List;

import com.etc.entity.Topictype;

public interface TopicTypeMapper {

	/**
	 * 获取所有帖子的类型信息
	 * 
	 * @return
	 */
	public List<Topictype> queryAllTopictype();
	
	/**
	 * 根据帖子类型ID获取帖子类型
	 * 
	 * @param topicType_id
	 * @return
	 */
	public List<Topictype> queryTopictypeBytypeId(Integer topicType_id);
	
}
