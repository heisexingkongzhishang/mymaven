package com.etc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.TopicsMapper;
import com.etc.entity.Topics;
import com.etc.service.TopicsService;

@Transactional
@Service("topicsService")
public class TopicsServiceImpl implements TopicsService {

	@Resource
	private TopicsMapper topicsMapper;
	
	@Override
	public List<Topics> queryAllTopics() {
		// TODO Auto-generated method stub
		return topicsMapper.queryAllTopics();
	}

	@Override
	public List<Topics> queryTopicsByTypeId(Integer topicsType_id, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		List<Topics> topicsList = topicsMapper.queryTopicsByTypeId(topicsType_id, rowBounds);
		return topicsList;
	}
	
	@Override
	public Integer getCounts(Integer topicsType_id) {
		return topicsMapper.getCounts(topicsType_id);
	}

	@Override
	public List<Topics> getTopFive(Integer topicsType_id, RowBounds rowBounds) {
		return topicsMapper.getTopFive(topicsType_id, rowBounds);
	}

}
