package com.self.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.self.pojo.Employee;

@Mapper
public interface EmployeeMapper {

	public List<Employee> getEmpByName(String cname);
	
	//查询所有用户
	public List<Employee> selectAll();
	
	//查询所有用户
	public List<Employee> selectListByName(String cname);
	
	public boolean updateBydoor(Employee employee);
}
