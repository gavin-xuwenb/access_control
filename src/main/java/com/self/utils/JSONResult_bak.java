package com.self.utils;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: 自定义响应数据结构
 *     200：表示成功
 *     500：表示错误，错误信息在msg字段中
 *     501：bean验证错误，不管多少个错误都以map形式返回
 *     502：拦截器拦截到用户token出错
 *     555：异常抛出信息
 */
public class JSONResult_bak {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    
    private String token;

    public static JSONResult_bak build(Integer status, String msg, Object data) {
        return new JSONResult_bak(status, msg, data);
    }

    //正常返回，返回一个对象
    public static JSONResult_bak ok(Object data) {
        return new JSONResult_bak(data);
    }
    
    //正常返回，返回一个对象,外加一个token
    public static JSONResult_bak ok(Object data,String token) {
    	//public JSONResult(Integer status, String msg, Object data,String token) {
        return new JSONResult_bak(200,"OK",data,token);
    }

    public static JSONResult_bak ok() {
        return new JSONResult_bak(null);
    }
    
    public static JSONResult_bak ok(String token) {
        return new JSONResult_bak(token);
    }
    
    public static JSONResult_bak errorMsg(String msg) {
        return new JSONResult_bak(500, msg, null);
    }
    
    public static JSONResult_bak errorMap(Object data) {
        return new JSONResult_bak(501, "error", data);
    }
    
    public static JSONResult_bak errorTokenMsg(String msg) {
        return new JSONResult_bak(502, msg, null);
    }
    
    public static JSONResult_bak errorException(String msg) {
        return new JSONResult_bak(555, msg, null);
    }

    public JSONResult_bak() {

    }
    public JSONResult_bak(String token) {
    	this.status = 200;
        this.msg = "OK";
        this.token = token;
    }
    public JSONResult_bak(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public JSONResult_bak(Integer status, String msg, Object data,String token) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.token = token;
    }

    public JSONResult_bak(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

	/**
     * 
     * @Description: 将json结果集转化为JSONResult对象
     *                 需要转换的对象是一个类
     */
    public static JSONResult_bak formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, JSONResult_bak.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 
     * @Description: 没有object对象的转化
     * @param json
     * @return
     */
    public static JSONResult_bak format(String json) {
        try {
            return MAPPER.readValue(json, JSONResult_bak.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @Description: Object是集合转化
     *                 需要转换的对象是一个list
     * @param jsonData
     * @param clazz
     * @return
     */
    public static JSONResult_bak formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}