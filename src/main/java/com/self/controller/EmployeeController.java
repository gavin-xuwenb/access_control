package com.self.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.self.pojo.Employee;
import com.self.service.EmployeeService;
import com.self.utils.JSONResult;

import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	 //@RequestMapping(value = "/getEmpByName",method = RequestMethod.GET)
	 	@GetMapping("getEmpByName")
	    public JSONObject testLogin(String cname,Integer pageNum, Integer pageSize) {
	        
	 		PageHelper.startPage(pageNum,pageSize);
	        List<Employee> userList = employeeService.getEmpByName("%"+cname+"%");
	        PageInfo<Employee> pageInfo=new PageInfo<>(userList);
	        return JSONResult.ok(userList,pageInfo.getTotal());
	        
	    }
	 
	    @GetMapping("selectAll")
	    public JSONObject findByPaging(Integer pageNum, Integer pageSize){
	        PageHelper.startPage(pageNum,pageSize);
	        List<Employee> userList = employeeService.selectAll();
	        PageInfo<Employee> pageInfo=new PageInfo<>(userList);
	        return JSONResult.ok(userList,pageInfo.getTotal());
	    }
	    
	    @GetMapping("selectListByName")
	    public JSONObject selectListByName(String cname,Integer pageNum, Integer pageSize){
	        PageHelper.startPage(pageNum,pageSize);
	        List<Employee> userList = null;
	        if(StringUtils.isBlank(cname)) {
	        	 userList = employeeService.selectListByName(null);
	        }else {
	        	 userList = employeeService.selectListByName("%"+cname+"%");
	        }
	        
	        PageInfo<Employee> pageInfo=new PageInfo<>(userList);
	        return JSONResult.ok(userList,pageInfo.getTotal());
	    }
	    
	    @GetMapping("updateBydoor")
	    public JSONObject updateBydoor(Integer seq,String doorsat1){
    		Employee employee = new Employee();
    		employee.setSeq(seq);
    		employee.setDoorsat1(doorsat1);
        	boolean flag = employeeService.updateBydoor(employee);
	        return JSONResult.ok(flag);
	    }
}
