package com.stip.net.serviceImpl;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stip.net.dao.SysAuthorityDao;
import com.stip.net.dao.SysRoleDao;
import com.stip.net.dao.UserDao;
import com.stip.net.entity.SysAuthority;
import com.stip.net.entity.SysRole;
import com.stip.net.entity.SysRoleExample;
import com.stip.net.entity.User;
import com.stip.net.entity.UserExample;
import com.stip.net.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysAuthorityDao sysAuthorityDao;

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
	
	public List<SysRole> selectRoleByUserName(String username) {
		UserExample example=new UserExample();
		example.createCriteria().andNameEqualTo(username);
		List<User> userList=userDao.selectByExample(example);
		
		if(userList!=null&&userList.size()>0){
			User user=userList.get(0);
			String[] roles=user.getRoles().split(";");
			
			SysRoleExample roleExample=new SysRoleExample();
			roleExample.createCriteria().andRoleIdIn(Arrays.asList(roles));
			List<SysRole> roleList=sysRoleDao.selectByExample(roleExample);
			
			return roleList;
		}else{
			return null;
		}
	}
	

}
