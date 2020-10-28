package com.self.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.pojo.User;
import com.self.service.UserService;
import com.self.utils.JSONResult;
import com.self.utils.TokenUtil;

@RestController
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONResult login(@RequestBody Map<String,Object> para) throws JsonProcessingException {
        
    	//String username=(String)para.get("username");
        //String password=(String)para.get("password");
    	String username = "jack";
    	String password = "1234567";
        System.out.print("username==>"+username);
        System.out.print("password==>"+password);
        
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
        	return JSONResult.errorMsg("用户名活密码不能为空...");
        }
        
        boolean flag = userService.queryUsernameIsExist(username);
        
        
        
       
//        HashMap<String,Object> hs=new HashMap<>();
//        hs.put("token",token);
//        ObjectMapper objectMapper=new ObjectMapper();
//        return objectMapper.writeValueAsString(hs);
       
        if(!flag) {
        	return JSONResult.errorMsg("用户名不存在");
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
    public JSONResult testLogin(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password) {

        System.out.println("username==>"+username);
        System.out.println("password==>"+password);
        
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
        	return JSONResult.errorMsg("用户名活密码不能为空...");
        }
        
        boolean flag = userService.queryUsernameIsExist(username);
       
        if(!flag) {
        	return JSONResult.errorMsg("用户名不存在");
        }else {
        	String token= TokenUtil.sign(new User(username,password));
        	return JSONResult.ok(token);
        }
    }
}
