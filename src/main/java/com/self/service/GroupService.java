package com.self.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.dao.GroupMapper;
import com.self.pojo.Group;

@Service
public class GroupService {

	@Autowired
	GroupMapper groupMapper;

    public List<Group> selectAll() {
    	return groupMapper.selectAll();
    }
}
