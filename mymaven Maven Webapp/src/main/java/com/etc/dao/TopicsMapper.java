package com.etc.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.etc.entity.Topics;

public interface TopicsMapper {

	/**
	 * 获取所有帖子
	 * @param
	 * @return
	 */
	public List<Topics> queryAllTopics();
	
	/**
	 * 根据帖子ID获取帖子
	 * @param topics_id
	 * @return
	 */
	public Topics queryTopicsByTopicsId(Integer topics_id);
	
	/**
	 * 根据帖子类型获取帖子
	 * @param topicsTypeName
	 * @return
	 */
	public List<Topics> queryTopicsByTypeId(Integer topicsType_id, RowBounds rowBounds);
	
	/**
	 * 获取某类型帖子数量
	 * @param topicsType_id
	 * @return
	 */
	public Integer getCounts(Integer topicsType_id);
	
	/**
	 * 获取点击量和回复量前十的帖子
	 * @param topicsType_id
	 * @return
	 */
	public List<Topics> getTopFive(Integer topicsType_id, RowBounds rowBounds);
	
}
