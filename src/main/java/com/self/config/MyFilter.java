package com.self.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/*",filterName = "myFilter")
public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) sResponse;

	    response.setHeader("Access-Control-Allow-Origin", "*"); //解决跨域访问报错
	    response.setHeader("Access-Control-Allow-Credentials","true");
	    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间
	    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");
	    //response.setHeader("Location", "http://www.baidu.com"); // 支持HTTP 1.0. response.setHeader("Expires", "0");
	    //response.setHeader("Refresh", "3;url=http://www.baidu.com");
	    
	    //response.setStatus(302);//临时定向响应码

	    //response.setHeader("Location", "http://www.baidu.com");
	    
	    chain.doFilter(sRequest, sResponse);
		
	}

}
