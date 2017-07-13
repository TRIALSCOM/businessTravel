package com.businessTravel.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.businessTravel.domain.Employee;

import static com.businessTravel.util.BusinessConstant.*;

public class AuthorizationInterceptor implements HandlerInterceptor {
   
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		String servletPath=request.getServletPath();
		for(String s:INGORE_URI){
			if(servletPath.contains(s)){
				System.out.println(servletPath);
				flag=true;
				break;
			}
			
		}
		
		if(!flag){
			Employee employee=(Employee)request.getSession().getAttribute("employee");
			if(employee==null){
				request.setAttribute("msg", "请登录");
				request.getRequestDispatcher("index").forward(request, response);
				
			}else{
				flag=true;
				
			}
			
		}
		
		return flag;
	}
   
}
