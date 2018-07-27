package com.javacircle.mybatis.config;

import javax.inject.Named;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.javacircle.mybatis.mapper.EmpMapper;
import com.javacircle.mybatis.mapper.UsersMapper;

@Configuration
public class MyBatisConfig {
	private static final String ONE_SESSION_FACTORY = "oneSessionFactory";
	private static final String ANOTHER_SESSION_FACTORY = "anotherSessionFactory";

	@Bean(name = ONE_SESSION_FACTORY, destroyMethod = "")
	@Primary
	public SqlSessionFactoryBean sqlSessionFactory(
			@Named(DatabaseConfig.PRIMARY_DATASOURCE) final DataSource oneDataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(oneDataSource);
		SqlSessionFactory sqlSessionFactory;
		sqlSessionFactory = sqlSessionFactoryBean.getObject();
		sqlSessionFactory.getConfiguration().addMapper(UsersMapper.class);
		// Various other SqlSessionFactory settings
		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperFactoryBean<UsersMapper> etrMapper(
			@Named(ONE_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
		MapperFactoryBean<UsersMapper> factoryBean = new MapperFactoryBean<>(UsersMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
		return factoryBean;
	}

	@Bean(name = ANOTHER_SESSION_FACTORY, destroyMethod = "")
	public SqlSessionFactoryBean censoSqlSessionFactory(
			@Named(DatabaseConfig.SECONDARY_DATASOURCE) final DataSource anotherDataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(anotherDataSource);
		final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		sqlSessionFactory.getConfiguration().addMapper(EmpMapper.class);
		// Various other SqlSessionFactory settings
		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperFactoryBean<EmpMapper> dbMapper(
			@Named(ANOTHER_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
		MapperFactoryBean<EmpMapper> factoryBean = new MapperFactoryBean<>(EmpMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
		return factoryBean;
	}
}
