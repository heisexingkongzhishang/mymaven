package com.etc.dao;

public interface UserCenterMapper {
	public int collectionTopic(Integer user_id);
	
	public int collectionVideo(Integer user_Id);
	
	public int myVideo(Integer user_id);
	
	public int myTopic(Integer user_id);
}
