package com.self.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.self.pojo.Machine;

@Mapper
public interface MachineMapper {
	
	public List<Machine> getAll();
}
