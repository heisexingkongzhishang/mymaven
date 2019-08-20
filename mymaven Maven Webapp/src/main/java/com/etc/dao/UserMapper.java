package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.entity.User;

public interface UserMapper {

	/**
	 * 增加用户信息
	 * 
	 * @param connection
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(User user) throws Exception;

	/**
	 * 通过userCode获取User
	 * 
	 * @param connection
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(@Param("userCode") String userCode)
			throws Exception;

	/**
	 * 通过条件查询-userList
	 * 
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList(@Param("userName") String userName,
			@Param("userRole") Integer userRole, @Param("from") Integer from,
			@Param("pageSize") Integer pageSize) throws Exception;

	/**
	 * 通过条件查询-用户表记录数
	 * 
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public int getUserCount(@Param("user_name") String user_name,
			@Param("userRole") Integer userRole) throws Exception;

	/**
	 * 通过userId获取user
	 * 
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getUserById(@Param("id") String id) throws Exception;

	/**
	 * 通过userId删除user
	 * 
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteUserById(@Param("id") Integer id) throws Exception;

	/**
	 * 修改用户信息
	 * 
	 * @param connection
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modify(User user) throws Exception;

	/**
	 * 修改当前用户密码
	 * 
	 * @param connection
	 * @param id
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public int updatePwd(@Param("id")Integer id, @Param("pwd")String pwd) throws Exception;

}
