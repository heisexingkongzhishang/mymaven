package com.etc.service.impl;

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
	@Transactional(propagation=Propagation.SUPPORTS)
	public boolean userUpdate(Integer user_id,String user_name,String user_sex) {
		// TODO Auto-generated method stub
		return userCenterMapper.userUpdate(user_id,user_name,user_sex)>0;
	}

	@Override
	public User userQuery(Integer user_id) {
		// TODO Auto-generated method stub
		return userCenterMapper.userQuery(user_id);
	}
	
	

}
