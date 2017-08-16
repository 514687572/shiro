package com.stip.net.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stip.net.dao.SysRoleDao;
import com.stip.net.dao.UserDao;
import com.stip.net.entity.User;
import com.stip.net.entity.UserExample;
import com.stip.net.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private SysRoleDao sysRoleDao;

	public User getUserById(int id) {
		return userDao.selectByPrimaryKey(id);
	}

	public User findUserByLoginName(String username) {
		UserExample example=new UserExample();
		example.createCriteria().andNameEqualTo(username);
		List<User> userList=userDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}else{
			return null;
		}
	}

}
