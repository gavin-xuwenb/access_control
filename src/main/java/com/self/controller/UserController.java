package com.self.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.self.pojo.User;
import com.self.service.UserService;

import com.self.utils.JSONResult;
import com.self.utils.TokenUtil;

import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody Map<String,Object> para) throws JsonProcessingException {
        
    	String username=(String)para.get("username");
        String password=(String)para.get("password");
 
        System.out.print("username==>"+username);
        System.out.print("password==>"+password);
        
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
        	return JSONResult.failMsg("用户名活密码不能为空...");
        }
        
        User  user = userService.getUserByName(username);
       
        if(user==null) {
        	return JSONResult.failMsg("用户名不存在");
        }else {
        	String token= TokenUtil.sign(new User(username,password));
        	return JSONResult.ok(token);
        }
    }

    @RequestMapping(value = "/testToken",method = RequestMethod.POST)
    @ResponseBody
    public String test(@RequestBody Map<String,Object> para) throws JsonProcessingException {
    	System.out.println("testToken begin ... ");
        HashMap<String,Object> hs=new HashMap<>();
        hs.put("data","data");
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(hs);
    }
    
    //@GetMapping("/testLogin")
    @RequestMapping(value = "/testLogin",method = RequestMethod.GET)
    public JSONObject testLogin(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password) {
        
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
        	return JSONResult.failMsg("用户名活密码不能为空...");
        }
        
//        User  user = userService.getUserByName(username);
//        if(user == null) {
//        	return JSONResult.failMsg("用户名不存在");
//        }else {
//        	System.out.println(user.getPassword());
//        	String token= TokenUtil.sign(new User(username,password));
//        	return JSONResult.ok(user,token);
//        }
        List<User> userList = userService.getUsersByLastNameLike("%"+username+"%");
        
        for(User user:userList ) {
        	System.out.println(user.getUsername());
        }
        
        return JSONResult.ok(userList);
        
    }
    
    @GetMapping("selectAll")
    public JSONObject findByPaging(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userService.selectAll();
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        return JSONResult.ok(userList,pageInfo.getSize());
    }
}
