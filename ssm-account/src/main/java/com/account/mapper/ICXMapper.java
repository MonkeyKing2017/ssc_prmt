package com.account.mapper;

import org.apache.ibatis.annotations.Param;

import com.account.bean.CXUser;

public interface ICXMapper {
	CXUser findUserByNameAndPassword(String name,String password);
	
	int deleteById(Long id);
	
	int addUser(CXUser cx);
	
	int updatePassword(CXUser cx);
	
	CXUser findCXBySession(@Param("account") String account ,@Param("password") String password);
	
	CXUser findCXByAccount(String account);

	CXUser findCXById(Long id); 
}
