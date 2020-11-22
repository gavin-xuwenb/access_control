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
}
