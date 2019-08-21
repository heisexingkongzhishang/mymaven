package com.etc.dao;

import com.etc.entity.Topics;

public interface UserCenterMapper {
	public Topics collectionTopic(Integer user_id);
	
	public Integer collectionVideo(Integer user_Id);
	
	public Integer myVideo(Integer user_id);
	
	public Topics myTopic(Integer user_id);
	
	public Integer userUpdate(Integer user_id,String user_name,String user_sex);
}
