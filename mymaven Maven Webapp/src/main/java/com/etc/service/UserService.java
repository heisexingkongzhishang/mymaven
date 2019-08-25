package com.etc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.entity.User;


public interface UserService {
	/**
	 * 增加用户信息
	 * @param user
	 * @return
	 */
	public boolean add(User user);
	
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User login(String user_phone,String user_password);
	
	/**
	 * 通过user_id获取User
	 * 
	 * @param connection
	 * @param user_phone
	 * @return
	 * @throws Exception
	 */
	public User queryUserById(@Param("user_id") Integer user_id)
			throws Exception;
	
	/**
	 * 根据条件查询用户列表
	 * @param queryUserName
	 * @param queryUserRole
	 * @return
	 */
	public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo, int pageSize);
	/**
	 * 根据条件查询用户表记录数
	 * @param queryUserName
	 * @param queryUserRole
	 * @return
	 */
	public int getUserCount(String queryUserName,int queryUserRole);
	
	/**
	 * 根据userCode查询出User
	 * @param userCode
	 * @return
	 */
	public User selectUserCodeExist(String userCode);
	
	/**
	 * 根据ID删除user
	 * @param delId
	 * @return
	 */
	public boolean deleteUserById(Integer id);
	
	/**
	 * 根据ID查找user
	 * @param id
	 * @return
	 */
	public User getUserById(String id);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean modify(User user);
	
	/**
	 * 根据userId修改密码
	 * @param id
	 * @param pwd
	 * @return
	 */
	public boolean updatePwd(Integer id,String pwd);
}
