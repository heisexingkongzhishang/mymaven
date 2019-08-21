package com.etc.service;

public interface UserCenterService {
	//用户昵称和性别更改
	public boolean userUpdate(Integer user_id,String user_name,String user_sex);
}
