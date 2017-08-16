package com.stip.net.service;

import java.util.Collection;
import java.util.List;

import com.stip.net.entity.SysRole;
import com.stip.net.entity.User;

public interface UserService {
	public User getUserById(int id);

	public User findUserByLoginName(String username);
	
	public List<SysRole> selectRoleByUserName(String username);
	
	public Collection<String> selectAuthorById(List<Integer> listAuId);
}
