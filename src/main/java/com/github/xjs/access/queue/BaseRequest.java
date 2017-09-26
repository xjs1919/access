package com.github.xjs.access.queue;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 下午3:02:30<br/>
 * 
 * 队列的元素必须集成这个基类
 */
public class BaseRequest {  
	  
    @SuppressWarnings("rawtypes")  
    private LazyExecutable executor;  
  
    @SuppressWarnings("rawtypes")  
    public void setLazyExecutor(LazyExecutable callback) {  
        this.executor = callback;  
    }  
      
    @SuppressWarnings("rawtypes")  
    public LazyExecutable getLazyExecutor() {  
        return executor;  
    }  
}  