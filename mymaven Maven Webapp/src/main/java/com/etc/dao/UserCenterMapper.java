package com.etc.dao;

import java.util.List;

import com.etc.entity.Topics;
import com.etc.entity.User;

public interface UserCenterMapper {
	public List<String> collectionTopic(Integer user_id);
	
	public Integer collectionVideo(Integer user_Id);
	
	public Integer myVideo(Integer user_id);
	
	public List<String> myTopic(Integer user_id);
	
	public Integer userUpdate(Integer user_id,String user_name,String user_sex);
	
	public User userQuery(Integer user_id);
	
	public Integer userPicUpdate(Integer user_id,String user_picture);
}
