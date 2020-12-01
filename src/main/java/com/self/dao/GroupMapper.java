package com.self.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.self.pojo.Group;

@Mapper
public interface GroupMapper {
	public List<Group> selectAll();
}
