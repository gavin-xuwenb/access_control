package com.self.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.self.dao.SystemUserMapper;

import com.self.pojo.SystemUser;

@Service
public class SystemUserService {
	@Autowired
	SystemUserMapper systemUserMapper;
	//根据用户名查询用户
    public List<SystemUser> getUserByName(String name) {
    	return systemUserMapper.getUserByName(name);
    }
    
    public List<SystemUser> selectAll(){
    	return systemUserMapper.selectAll();
    }
    
    public boolean delUser(String seq){
    	return systemUserMapper.delUser(seq);
    }
    
    public boolean addUser(SystemUser user){
    	return systemUserMapper.addUser(user);
    }
}
