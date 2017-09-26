/**
 * 
 */
package com.github.xjs.access.actuator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;

import com.github.xjs.access.queue.LazyExecutable;
import com.github.xjs.access.queue.WorkingService;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 下午3:02:30<br/>
 * 
 * 供{@link com.github.xjs.access.interceptor.AccessInterceptor}使用，保存方法的调用信息<br>
 * 供{@link com.inspur.eyun.causer.actuator.AccessHealthIndicator}使用，读取方法的调用信息<br>
 * 信息首先是保存到队列，然后串行出队，保证线程安全
 */
@Service
public class AccessHolder {
	
	private static ThreadLocal<AccessInfo> accessHolder = new ThreadLocal<AccessInfo>();

	private static ConcurrentHashMap<Class<?>, ControllerAccessInfo> map = new ConcurrentHashMap<Class<?>, ControllerAccessInfo>();

	private static WorkingService<AccessRequest> workingService = new WorkingService<AccessRequest>();
	
	static {
		workingService.start();
	}
	
	public static void accessStart(AccessInfo mai) {
		accessHolder.set(mai);
	}
	
	public static AccessInfo getAccessInfo() {
		return accessHolder.get();
	}
	
	public static void accessError() {
		AccessInfo ai = getAccessInfo() ;
		if(ai == null) {
			return;
		}
		ai.setOccurError(true);
	}
	
	public static void accessEnd() {
		AccessInfo ai = getAccessInfo();
		if(ai == null) {
			return;
		}
		ai.setEndAt(System.currentTimeMillis());
		accessHolder.set(null);
		workingService.execute(new AccessRequest(ai), new LazyExecutable<AccessRequest>() {
			@Override
			public void lazyExecute(AccessRequest request) {
				addAccessInfo(request.getAi());
			}
		});
	}
	
	private static void addAccessInfo(AccessInfo ai) {
		HandlerMethod hm = ai.getHm();
		Class<?> controllerClazz = hm.getBeanType();
		if(!AccessAble.class.isAssignableFrom(controllerClazz)) {
			return;
		}
		Method method = hm.getMethod();
		long startAt = ai.getStartAt();
		long endAt = ai.getEndAt();
		boolean occurError = ai.isOccurError();
		long useTime = endAt - startAt;
		String uri = ai.getUri();
		ControllerAccessInfo cai = map.get(controllerClazz);
		if(cai == null) {
			cai = new ControllerAccessInfo();
			cai.setControllerClazz(controllerClazz);
			map.put(controllerClazz, cai);
		}
		List<MethodAccessInfo> mais = cai.getMethodInfos();
		if(mais == null) {
			mais = new ArrayList<MethodAccessInfo>();
			cai.setMethodInfos(mais);
		}
		MethodAccessInfo mai = getMethodAccessInfo(mais, method);
		if(mai == null) {
			mai = new MethodAccessInfo();
			mai.setMethod(method.getName());
			mai.setUri(uri);
			mai.setInvokeCount(1);
			if(occurError) {
				mai.setErrorCount(1);
			}else {
				mai.setSuccessCount(1);
			}
			mai.setMinMillSecond(useTime);
			mai.setMaxMillSecond(useTime);
			mai.setAvgMillSecond(useTime);
			mais.add(mai);
		}else {
			if(useTime < mai.getMinMillSecond()) {
				mai.setMinMillSecond(useTime);
			}
			if(useTime > mai.getMaxMillSecond()) {
				mai.setMaxMillSecond(useTime);
			}
			mai.setInvokeCount(mai.getInvokeCount() + 1);
			if(occurError) {
				mai.setErrorCount(mai.getErrorCount()+1);
			}else {
				mai.setSuccessCount(mai.getSuccessCount()+1);
			}
			mai.setAvgMillSecond((mai.getAvgMillSecond()+useTime)/2);
		}
	}
	
	private static MethodAccessInfo getMethodAccessInfo(List<MethodAccessInfo> mais, Method method) {
		for(MethodAccessInfo mai : mais) {
			if(method.getName().equals(mai.getMethod())) {
				return mai;
			}
		}
		return null;
	}
	
	public static Map<String, Object> getAllAccessInfo() {
		Map<String, Object> result = new HashMap<String, Object>();
		for(Map.Entry<Class<?>, ControllerAccessInfo> entry : map.entrySet()) {
			ControllerAccessInfo cai = entry.getValue();
			result.put(cai.getControllerClazz().getSimpleName(), cai.getMethodInfos());
		}
		return result;
	}
}
