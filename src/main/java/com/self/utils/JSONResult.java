package com.self.utils;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.json.JSONObject;

import cn.hutool.json.JSONUtil;

public class JSONResult {
	protected static final Integer FAIL_CODE = 500;
	protected static final Integer SUCCESS_CODE = 200;
	//响应吗
	protected Integer status;
	//响应信息
	protected String message;
	//响应数据
	protected Object data;
	//响应数据
	protected String token;
	
	public JSONResult() {
		super();
	}
 
 
	public JSONResult(Integer status, String message, Object data,String token) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.token = token;
	}
 
 
	public Integer getStatus() {
		return status;
	}
 
 
	public void setStatus(Integer status) {
		this.status = status;
	}
 
 
	public String getMessage() {
		return message;
	}
 
 
	public void setMessage(String message) {
		this.message = message;
	}
 
 
	public Object getData() {
		return data;
	}
 
 
	public void setData(Object data) {
		this.data = data;
	}
 
 
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	@Override
	public String toString() {
		return "JSONResult [status=" + status + ", message=" + message + ", toke=" + token+ ", data=" + data + "]";
	}
	
	//参数object是list集合
	public static JSONObject ok(Object object,Long count) {
		JSONObject json =JSONUtil.createObj();
		JSONObject json_list =JSONUtil.createObj();
		json_list.put("list", object);
		json_list.put("recordNumber", count);
		json.put("status", SUCCESS_CODE);
		json.put("data", json_list);
		return json;
	}
	//参数object是某个对象
	public static JSONObject ok(Object object) {
		JSONObject json =JSONUtil.createObj();
		json.put("status", SUCCESS_CODE);
		json.put("data", object);
		return json;		
	}
	
	public static JSONObject ok(Object object,String token) {
		JSONObject json =JSONUtil.createObj();
		json.put("status", SUCCESS_CODE);
		json.put("data", object);
		json.put("token", token);
		return json;
		
	}
	
	public static JSONObject failMsg(String message) {
		JSONObject json = JSONUtil.createObj();
		json.put("status", FAIL_CODE);
		json.put("data", null);
		json.put("message", message);
		return json;
	}
}
