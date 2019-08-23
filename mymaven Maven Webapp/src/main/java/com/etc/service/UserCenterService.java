package com.etc.service;

import com.etc.entity.User;

public interface UserCenterService {
	//用户昵称和性别更改
	public boolean userUpdate(Integer user_id,String user_name,String user_sex);
	
	//查询用户信息
	public User userQuery(Integer user_id);
	
	public Integer userPicUpdate(Integer user_id,String user_picture);
}
