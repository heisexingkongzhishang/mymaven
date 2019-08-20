package com.etc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.etc.dao.UserMapper;
import com.etc.entity.User;
import com.etc.service.UserService;

/**
 * service层捕获异常，进行事务处理 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 * 
 * @author Administrator
 * 
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean add(User user) {
		boolean flag = false;
		try {
			int updateRows = userMapper.add(user);
			if (updateRows > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public User login(String userCode, String userPassword) {
		User user = null;
		try {
			user = userMapper.getLoginUser(userCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 匹配密码
		if (null != user) {
			if (!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}

	@Override
	public List<User> getUserList(String queryUserName, int queryUserRole,
			int currentPageNo, int pageSize) {
		int from = (currentPageNo - 1) * pageSize;
		List<User> userList = null;
		try {
			userList = userMapper.getUserList(queryUserName, queryUserRole,
					from, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User selectUserCodeExist(String userCode) {
		User user = null;
		try {
			user = userMapper.getLoginUser(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			user = null;
		}
		return user;
	}

	@Override
	public boolean deleteUserById(Integer id) {
		boolean flag = false;
		try {
			if (userMapper.deleteUserById(id) > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public User getUserById(String id) {
		User user = null;
		try {
			user = userMapper.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			user = null;
		}
		return user;
	}

	@Override
	public boolean modify(User user) {
		boolean flag = false;
		try {
			if (userMapper.modify(user) > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean updatePwd(Integer id, String pwd) {
		boolean flag = false;
		try {
			if (userMapper.updatePwd(id, pwd) > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}

	@Override
	public int getUserCount(String queryUserName, int queryUserRole) {
		int count = 0;
		try {
			count = userMapper.getUserCount(queryUserName, queryUserRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
