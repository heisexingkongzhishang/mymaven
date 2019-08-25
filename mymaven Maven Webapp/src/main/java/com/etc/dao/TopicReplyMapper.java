package com.etc.dao;

import java.util.List;

import com.etc.entity.Topicreply;

public interface TopicReplyMapper {
	
	/**
	 * 根据帖子ID查询该帖回复信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<Topicreply> queryTopicreplyByTopicsId(Integer topics_id);
	
	/**
	 * 按时间降序获取某帖子回复信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<Topicreply> queryTopicreplyOrderTime(Integer topics_id);
	
	/**
	 * 按回复ID查询回复信息
	 * @param reply_id
	 * @return
	 */
	public Topicreply queryReplyByReplyId(Integer reply_id);
	
	
}
