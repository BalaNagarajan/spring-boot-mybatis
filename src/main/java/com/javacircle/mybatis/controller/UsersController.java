package com.javacircle.mybatis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javacircle.mybatis.model.ErrorMessage;
import com.javacircle.mybatis.model.Users;
import com.javacircle.mybatis.response.UsersResponse;
import com.javacircle.mybatis.service.UsersService;

@RestController
@RequestMapping("/rest/api")
public class UsersController {

	@Autowired
	UsersService usersService;

	/**
	 * Logger object to log the application related messages
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/v1/users")
	public UsersResponse getAll() {
		UsersResponse usersResponseObj = new UsersResponse();
		if (usersService != null) {
			List<Users> usersList = usersService.getAllUsers();
			if (usersList != null) {
				usersResponseObj.setUsersList(usersList);
				usersResponseObj.setStatusCode(200);
				usersResponseObj.setValidRequest(true);
			}
		}
		return usersResponseObj;
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/v1/users/{userId}")
	public UsersResponse getUser(@PathVariable(name = "userId") String userId) {

		UsersResponse usersResponse = null;
		ErrorMessage errorMessage = null;
		try {
			if (!StringUtils.isEmpty(userId)) {
				Users usersObj = usersService.findUserById(Integer.parseInt(userId));
				if (usersObj != null && !StringUtils.isEmpty(usersObj.getName())) {
					usersResponse = new UsersResponse();
					usersResponse.setUsers(usersObj);
					usersResponse.setStatusCode(200);
					usersResponse.setValidRequest(true);
				} else {
					errorMessage = new ErrorMessage();
					errorMessage.setDescription("No User present for the Id : " + userId);
					usersResponse.setErrorMessage(errorMessage);
					usersResponse.setStatusCode(HttpStatus.OK.value());

				}

			}
		} catch (Exception e) {
			logger.debug("Exception In" + this.getClass().getName() + "Method:getUser" + e.getMessage());
		}

		return usersResponse;

	}

	// @GetMapping("/update")
	// private List<Users> update() {
	//
	// Users users = new Users();
	// users.setName("Youtube");
	// users.setSalary(2333L);
	//
	// usersMapper.insert(users);
	//
	// return usersMapper.findAll();
	// }
}
