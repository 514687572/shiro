package com.stip.net.service;

import com.stip.net.entity.User;

public interface UserService {
	public User getUserById(int id);

	public User findUserByLoginName(String username);
}
