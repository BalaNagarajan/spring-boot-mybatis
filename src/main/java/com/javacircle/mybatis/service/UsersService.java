package com.javacircle.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javacircle.mybatis.model.Users;

/**
 * 
 * @author N.Bala
 *
 */

@Service
public interface UsersService {

	/**
	 * 
	 * @return
	 */
    List<Users> getAllUsers();
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
    Users findUserById(int userId);
	
    /**
     * 
     * @param users
     */
	void saveUser(List<Users> users);
	
 
}
