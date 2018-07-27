package com.javacircle.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javacircle.mybatis.model.Emp;
@Service
public interface EmpService {

	/**
	 * 
	 * @return
	 */
	List<Emp> getAllUsers();

}
