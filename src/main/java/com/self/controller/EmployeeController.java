package com.self.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.self.pojo.Employee;
import com.self.pojo.User;
import com.self.service.EmployeeService;
import com.self.utils.JSONResult;

import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	 @RequestMapping(value = "/queryList",method = RequestMethod.GET)
	    public JSONObject testLogin(@RequestParam(name = "cname") String cname) {
	        
	        if(StringUtils.isBlank(cname)) {
	        	return JSONResult.failMsg("用户名活密码不能为空...");
	        }
	        
	        List<Employee> userList = employeeService.getEmpByName("%"+cname+"%");
	        
	        for (Employee emp:userList) {
	        	System.out.println(emp.getPicture());
	        }
	        
	        return JSONResult.ok(userList);
	        
	    }
}
