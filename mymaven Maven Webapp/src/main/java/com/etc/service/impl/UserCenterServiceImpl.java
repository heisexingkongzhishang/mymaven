package com.etc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.UserCenterMapper;
import com.etc.entity.User;
import com.etc.service.UserCenterService;

@Transactional
@Service("userCenterService")
public class UserCenterServiceImpl implements UserCenterService {

	@Resource
	private UserCenterMapper userCenterMapper;
	
	@Override
	public boolean userUpdate(Integer user_id,String user_name,String user_sex) {
		// TODO Auto-generated method stub
		return userCenterMapper.userUpdate(user_id,user_name,user_sex)>0;
	}

	@Override
	public User userQuery(Integer user_id) {
		// TODO Auto-generated method stub
		return userCenterMapper.userQuery(user_id);
	}

	@Override
	public Integer userPicUpdate(Integer user_id, String user_picture) {
		// TODO Auto-generated method stub
		return userCenterMapper.userPicUpdate(user_id, user_picture);
	}

	@Override
	public List<String> myTopic(Integer user_id) {
		// TODO Auto-generated method stub
		return userCenterMapper.myTopic(user_id);
	}

	@Override
	public List<String> collectionTopic(Integer id) {
		// TODO Auto-generated method stub
		return userCenterMapper.collectionTopic(id);
	}
	
	

}
