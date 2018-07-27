package com.javacircle.mybatis.response;

import java.util.List;

import com.javacircle.mybatis.model.Emp;
import com.javacircle.mybatis.model.ErrorMessage;
import com.javacircle.mybatis.model.Users;

public class EmpResponse extends ServiceResponse {

	private Emp emp;
	private List<Emp> empList;
	private ErrorMessage errorMessage;

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

}
