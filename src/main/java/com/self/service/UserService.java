package com.self.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.self.dao.UserMapper;
import com.self.pojo.User;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	//根据用户名查询用户
    public User getUserByName(String username) {
    	return userMapper.getUserByName(username);
    }
    
    public List<User> getUsersByLastNameLike(String username){
    	return userMapper.getUsersByLastNameLike(username);
    }
    
    public List<User> selectAll(){
    	return userMapper.selectAll();
    }
}
