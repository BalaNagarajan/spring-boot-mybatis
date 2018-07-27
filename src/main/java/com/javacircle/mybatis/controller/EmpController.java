package com.javacircle.mybatis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacircle.mybatis.model.Emp;
import com.javacircle.mybatis.response.EmpResponse;
import com.javacircle.mybatis.response.UsersResponse;
import com.javacircle.mybatis.service.EmpService;

@RestController
@RequestMapping("/rest/api")
public class EmpController {

	@Autowired
	EmpService empService;

	/**
	 * Logger object to log the application related messages
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/v1/emp")
	public EmpResponse getAll() {
		EmpResponse empResponseObj = new EmpResponse();
		if (empService != null) {
			List<Emp> empList = empService.getAllUsers();
			if (empList!= null) {
				empResponseObj.setEmpList(empList);
				empResponseObj.setStatusCode(200);
				empResponseObj.setValidRequest(true);
			}
		}
		return empResponseObj;
	}

}
