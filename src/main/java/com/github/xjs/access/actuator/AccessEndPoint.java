/**
 * 
 */
package com.github.xjs.access.actuator;

import java.util.Map;

import org.springframework.boot.actuate.endpoint.Endpoint;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月26日 上午9:44:19<br/>
 * 
 * 提供应用的接口调用信息
 * 
 * 思想：通过拦截器{@link com.github.xjs.access.interceptor.AccessInterceptor}记录方法的开始时间和结束时间
 * 
 */
public class AccessEndPoint implements Endpoint<Map<String, Object>> {

	public String getId() {
        return "access";
    }
    
    public boolean isEnabled() {
        return true;
    }
    
    public boolean isSensitive() {
        return false;
    }
    
    public Map<String, Object> invoke() {
    	return AccessHolder.getAllAccessInfo();
    }
}
