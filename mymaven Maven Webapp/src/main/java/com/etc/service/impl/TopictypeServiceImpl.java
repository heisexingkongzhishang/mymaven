package com.etc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.TopicTypeMapper;
import com.etc.entity.Topictype;
import com.etc.service.TopictypeService;

@Transactional
@Service("topictypeService")
public class TopictypeServiceImpl implements TopictypeService{

	@Resource
	private TopicTypeMapper topicTypeMapper;
	
	@Override
	public List<Topictype> queryAllTopictype() {
		return topicTypeMapper.queryAllTopictype();
	}

	@Override
	public List<Topictype> queryTopictypeBytypeId(Integer topicType_id) {
		if(topicType_id != null){
			return topicTypeMapper.queryTopictypeBytypeId(topicType_id);
		}
		return null;
	}

}
