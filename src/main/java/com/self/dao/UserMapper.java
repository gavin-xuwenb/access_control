package com.self.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.self.pojo.User;
@Mapper
public interface UserMapper {
	
	public User getUserById(Integer id);
	
	public User getUserByMap(Map<String,Object> map);
	
	public boolean addUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(Integer id);
	
	public User getUserByIdAndName(Integer id,String name);
	
	public User getUserByIdAndGender(@Param("id")Integer id,@Param("username")String username);
	
	//根据名称模糊查询，返回多条记录
	public List<User> getUsersByLastNameLike(String lastName);
	
	//返回一条记录的map，key就是列名字
	public Map<String,Object> getUserByIdReturnMap(Integer id);
	
	//返回多条记录的封装成map，key就是主键值，value 为 Employee对象
	//使用@MapKey告知mybatis 使用哪个字段作为key
	@MapKey("id")
	public Map<Integer,User> getUsersReturnMap(String lastName);
}
