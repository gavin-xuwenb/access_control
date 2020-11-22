package com.self.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.self.pojo.SystemUser;

@Mapper
public interface SystemUserMapper {
	public List<SystemUser> getUserByName(String name);
	
	//查询所有用户
	public List<SystemUser> selectAll();
}
