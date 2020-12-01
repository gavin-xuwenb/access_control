package com.self.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.self.pojo.Group;
import com.self.service.GroupService;
import com.self.utils.JSONResult;

import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/group")
public class GroupController {
	@Autowired
	private GroupService groupService;
	
	@GetMapping("selectAll")
    public JSONObject selectAll(){
		PageHelper.startPage(1,50);
        List<Group> mList = groupService.selectAll();
        PageInfo<Group> pageInfo=new PageInfo<>(mList);
        return JSONResult.ok(mList,pageInfo.getTotal());
    }
	
}
