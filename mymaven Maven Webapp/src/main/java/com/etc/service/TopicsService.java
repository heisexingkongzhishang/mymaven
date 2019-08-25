package com.etc.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.etc.entity.Topics;

public interface TopicsService {
	
	public List<Topics> queryAllTopics();
	
	public List<Topics> queryTopicsByTypeId(Integer topicsType_id, RowBounds rowBounds);
	
	public Integer getCounts(Integer topicsType_id);
	
	public List<Topics> getTopFive(Integer topicsType_id, RowBounds rowBounds);
	
}
