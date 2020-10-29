package com.self.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.self.utils.JSONResult_bak;
import com.self.utils.TokenUtil;

import net.sf.json.JSONObject;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if(token != null){
            boolean result = TokenUtil.verify(token);
            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }
        
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;  
        //将实体对象转换为JSON Object转换  
        JSONObject responseJSONObject = JSONObject.fromObject(JSONResult_bak.errorTokenMsg("会话认证失败"));  
        try{
        	out = response.getWriter();
        	out.append(responseJSONObject.toString());
            System.out.println("token认证失败，未通过拦截器");
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }finally {
        	if (out != null) {  
                out.close();  
            }  
        }
        return false;
    }
}
