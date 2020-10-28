package com.self.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.self.dao.UserMapper;
import com.self.pojo.User;
import com.self.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserMapper userMapper;
	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public boolean queryUsernameIsExist(String username) {
//		UsersExample example = new UsersExample();
//		Criteria  criteria = example.createCriteria();
//		criteria.andUsernameEqualTo(username);
//		List<User> users = userMapper.selectByExample(example);
//		return users.isEmpty()?false:true;
		return true;
	}

}
