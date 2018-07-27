package com.javacircle.mybatis.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.javacircle.mybatis.mapper.EmpMapper;
import com.javacircle.mybatis.mapper.UsersMapper;
import com.javacircle.mybatis.model.Emp;
import com.javacircle.mybatis.service.EmpService;

@Component
public class EmpServiceImpl implements EmpService {

	private EmpMapper empMapper;
	
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	/**
	 * 
	 * @return
	 */
	public List<Emp> getAllUsers() {

		return empMapper.findAll();

	}

}
