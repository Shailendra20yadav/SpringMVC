package com.sk.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.sk.spring.model.EmployeeTeo;
 
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter
{
 @Override
 public boolean preHandle(HttpServletRequest request,
   HttpServletResponse response, Object handler) throws Exception
 {
  String uri = request.getRequestURI();
  System.out.println("Uri in interceptor = "+ uri);
  
  if(!uri.endsWith("login") && !uri.endsWith("register"))
  {
   EmployeeTeo userData = (EmployeeTeo) request.getSession().getAttribute("LOGGEDIN_USER");
   if(userData == null)
   {
    response.sendRedirect("login");
    return false;
   }   
  }
  return true;
 }
 
 @Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	 	
	}
}
