package com.self.controller;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.tcp.TCPClient;
import com.self.utils.JSONResult;

import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/orderTest")
public class OrderTestController {
	 	@GetMapping("orderTest")
	    public JSONObject orderTest(String cmdStr){
	        
	 		if(StringUtils.isBlank(cmdStr)) {
	 			return JSONResult.failMsg("指令不能为空...");
	 		}
	 		
	 		System.out.println("发送指令："+cmdStr);
	 		try {
				 String str = TCPClient.sendMessage(cmdStr);
				 System.out.println("返回消息："+str);
				 return JSONResult.ok(str);
			} catch (IOException e) {
				 return JSONResult.failMsg("指令发送失败...");
			}
	       
	    }
}
