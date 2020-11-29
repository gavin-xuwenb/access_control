package com.self.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.self.pojo.Employee;
import com.self.pojo.Machine;
import com.self.service.MachineService;
import com.self.tcp.Command;
import com.self.tcp.TCPClient;
import com.self.utils.JSONResult;
import com.self.utils.Protocol_721E_Util;

import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/machine")
public class MachineController {
	@Autowired
	private MachineService machineService;
	
	@GetMapping("selectAll")
    public JSONObject selectAll(){
        
        PageHelper.startPage(1,50);
        List<Machine> mList = machineService.selectAll();
        PageInfo<Machine> pageInfo=new PageInfo<>(mList);
        return JSONResult.ok(mList,pageInfo.getTotal());
    }
	
	
	@GetMapping("checkCon")
    public JSONObject checkCon(String ip,Integer port) {
        
		int flag = TCPClient.getConnection(ip,port);
        return JSONResult.ok(flag);
        
    }
	
	
	@GetMapping("getTime")
    public JSONObject getTime(int tid,String ip,int port) {
 		try {
 			 String cmdStr = Protocol_721E_Util.getFullHexStr(tid,Command.GET_TIME.getValue(), "");
 			 System.out.println("发送指令："+cmdStr);
			 String str = TCPClient.sendMessage(cmdStr,ip,port);
			 System.out.println("返回消息："+str);
			 return JSONResult.ok(Protocol_721E_Util.timeForat(str));
		} catch (IOException e) {
			 return JSONResult.failMsg("指令发送失败...");
		}
    }
	
	
	@GetMapping("setTime")
    public JSONObject setTime(int tid,String ip,int port) {
 		try {
 			 String cmdStr = Protocol_721E_Util.getFullHexStr(tid, Command.SET_TIME.getValue(), Protocol_721E_Util.getTimeDATA());
 			 System.out.println("发送指令："+cmdStr);
			 String str = TCPClient.sendMessage(cmdStr,ip,port);
			 System.out.println("返回消息："+str);
			 return JSONResult.ok(str);
		} catch (IOException e) {
			 return JSONResult.failMsg("指令发送失败...");
		}
    }
	
	
	@GetMapping("openDoor")
    public JSONObject openDoor(int tid,String ip,int port) {
 		try {
 			 String cmdStr = Protocol_721E_Util.getFullHexStr(tid, Command.OPEN_DOOR.getValue(), "8401");
 			 System.out.println("发送指令："+cmdStr);
			 String str = TCPClient.sendMessage(cmdStr,ip,port);
			 System.out.println("返回消息："+str);
			 return JSONResult.ok(str);
		} catch (IOException e) {
			 return JSONResult.failMsg("指令发送失败...");
		}
    }
	
}
