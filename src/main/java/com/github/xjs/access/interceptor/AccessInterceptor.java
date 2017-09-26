/**
 * 
 */
package com.github.xjs.access.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.github.xjs.access.actuator.AccessHolder;
import com.github.xjs.access.actuator.AccessInfo;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 上午10:28:15<br/>
 * 
 * 记录方法的开始执行和结束执行时间，供{@link com.inspur.eyun.causer.actuator.AccessHealthIndicator}展示
 */
@Service
public class AccessInterceptor implements HandlerInterceptor  {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(handler instanceof HandlerMethod){
			HandlerMethod hm = (HandlerMethod)handler;
			AccessInfo mi = new AccessInfo();
			mi.setHm(hm);
			mi.setStartAt(System.currentTimeMillis());
			mi.setUri(request.getRequestURI());
			AccessHolder.accessStart(mi);
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception {
		//可以向view中写入数据
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		if(handler instanceof HandlerMethod){
			AccessHolder.accessEnd();
		}
	}
}
