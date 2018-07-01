package com.javacircle.mybatis.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.javacircle.mybatis.mapper.UsersMapper;
import com.javacircle.mybatis.model.Users;
import com.javacircle.mybatis.service.UsersService;

@Component
public class UsersServiceImpl implements UsersService {

	private UsersMapper usersMapper;

	public UsersServiceImpl(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	/**
	 * 
	 * @return
	 */
	public List<Users> getAllUsers() {

		return usersMapper.findAll();

	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public Users findUserById(int userId) {
		Users usersObj = null;

		return usersMapper.findUserById(userId);
	}

	/**
	 * 
	 * @param users
	 */
	public void saveUser(List<Users> users) {

	}

}
