package com.self.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.dao.EmployeeMapper;
import com.self.pojo.Employee;


@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	//根据用户名查询用户
    public List<Employee> getEmpByName(String cname) {
    	return employeeMapper.getEmpByName(cname);
    }
    
    public List<Employee> selectAll(){
    	return employeeMapper.selectAll();
    }
}
