package com.self.tcp;

/**
 * 指令集 枚举
 * @author xuwenbin
 */
public enum Command {
	
	OPEN_DOOR("开门","21"),
	SET_TIME("设置时间","23"),
	GET_TIME("获取时间","24"),
	SET_AUTH("权限设码","83");
	
	private String name;
    private String value;
    
    private Command(String name, String value) {
    	this.name = name;
        this.value = value;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
