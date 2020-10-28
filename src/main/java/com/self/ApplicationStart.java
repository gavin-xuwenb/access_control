package com.self;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages="com.self.dao")
//按照一个指定的包名，扫描下面所有需要的包
@ComponentScan(basePackages= {"com.self"})
public class ApplicationStart {
    //项目启动入口
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
}
