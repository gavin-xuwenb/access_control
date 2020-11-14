package com.self.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.self.pojo.Employee;
import com.self.pojo.Machine;
import com.self.service.EmployeeService;
import com.self.service.MachineService;
import com.self.tcp.TCPClient;
import com.self.utils.JSONResult;

import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/machine")
public class MachineController {
	@Autowired
	private MachineService machineService;
	
	@GetMapping("selectAll")
    public JSONObject selectAll(){
        List<Machine> mList = machineService.selectAll();
        return JSONResult.ok(mList,mList.size());
    }
	
	
	@GetMapping("checkCon")
    public JSONObject checkCon(String ip,Integer port) {
        
		int flag = TCPClient.getConnection(ip,port);
        return JSONResult.ok(flag);
        
    }
}
