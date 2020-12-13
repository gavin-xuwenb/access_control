package com.self.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
import com.self.tcp.Command;
import com.self.tcp.TCPClient;
import com.self.utils.CommonThread;
import com.self.utils.HexUtil;
import com.self.utils.JSONResult;
import com.self.utils.Protocol_721E_Util;
import com.self.utils.StringUtil;

import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private MachineService machineService;
	
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
	    public JSONObject updateBydoor(Employee employee){
        	boolean flag = employeeService.updateBydoor(employee);
	        return JSONResult.ok(flag);
	    }
	    
	    
	    @GetMapping("setAuth")
	    public JSONObject setAuth(Employee employee){
        	//boolean flag = employeeService.updateBydoor(employee);
    		List<Machine> mList = machineService.selectAll();
    		for(int i=0;i<mList.size();i++) {
    			Machine m = mList.get(i);
    			String dataStr = getDataStr(employee,m,i);
    			String cmdStr = Protocol_721E_Util.getFullHexStr(
    					Integer.valueOf(m.getIdadd()), 
    					Command.SET_AUTH.getValue(), 
    					dataStr);
    			CommonThread.senCMD(cmdStr,m.getIpadd(),m.getIpPort());
    		}
    		 return JSONResult.ok("200");
	    }
	    
	    public static String getDataStr(Employee employee,Machine machine,int index) {
	    	int tid = Integer.valueOf(machine.getAdd());
	    	
	    	StringBuffer sb = new StringBuffer("");
	    	String records = "01"; //笔数，16进制
	    	sb.append(records);
	    	sb.append(StringUtil.addZero(HexUtil.int2Hex(employee.getSeq()),4)); //位址
	    	
	    	String cardno = employee.getCardno();
	    	//10位数的卡号 分成两个5位数的数字，分别算出16进制值的4位数，拼接后左补齐16位0

	    	String str1 = StringUtil.addZero(HexUtil.int2Hex(Integer.valueOf(cardno.substring(0,5))),4);
	    	String str2 = StringUtil.addZero(HexUtil.int2Hex(Integer.valueOf(cardno.substring(5))),4);
	    	sb.append(StringUtil.addZero(str1+str2,16));
 
	    	
	    	String password = employee.getPassword();
	    	//密码转换成16进制值，左补齐8位0
	    	sb.append(StringUtil.addZero(HexUtil.int2Hex(Integer.valueOf(password)),8));
	    	
	    	
	    	sb.append(machine.getDeviceMode());
	    	String zone = "00";
	    	sb.append(zone);
	    	String group1 = "00";
	    	sb.append(group1);
	    	
	    	String doosat1 = employee.getDoorsat1();
	    	String group2 = HexUtil.tenTo16str(Integer.valueOf(doosat1.substring(2*index,2*index+1)));
	    	sb.append(group2);
 
	    	String outdate = employee.getOutdate();
	    	
	    	String year = HexUtil.tenTo16str(Integer.valueOf(outdate.substring(2,4))); //去年份的后两位 2019 ---19
	    	
	    	String month = HexUtil.tenTo16str(Integer.valueOf(outdate.substring(4,6)));
	    	
	    	String day = HexUtil.tenTo16str(Integer.valueOf(outdate.substring(6,8)));
	    	sb.append(year);
	    	sb.append(month);
	    	sb.append(day);
	    	
//	    	String level = "00";
//	    	String anti = "00";
//	    	String reserve = "000000";
	    	sb.append("0000000000");
	    	return sb.toString();
	    }
}
