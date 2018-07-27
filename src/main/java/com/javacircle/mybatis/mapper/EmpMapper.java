package com.javacircle.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.javacircle.mybatis.model.Emp;

@Mapper
public interface EmpMapper {

	@Select("SELECT * FROM EMP")
	List<Emp> findAll();

}
