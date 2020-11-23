package com.self.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.self.pojo.SystemUser;
import com.self.service.SystemUserService;
import com.self.utils.JSONResult;

import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/systemUser")
public class SystemUserController {
	@Autowired
	private SystemUserService userService;
	
	@GetMapping("selectAll")
    public JSONObject findByPaging(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<SystemUser> userList = userService.selectAll();
        PageInfo<SystemUser> pageInfo=new PageInfo<>(userList);
        return JSONResult.ok(userList,pageInfo.getSize());
    }
	
	@GetMapping("addUser")
    public JSONObject addUser(String name, String password){
		SystemUser user  = new SystemUser();
		user.setF999_01(name);
		user.setF999_02(password);
        boolean flag = userService.addUser(user);
        return JSONResult.ok(flag);
    }
	
	@GetMapping("delUser")
    public JSONObject delUser(String seq){
        boolean line = userService.delUser(seq);
        return JSONResult.ok(line);
    }
}
