package com.github.xjs.access.queue;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 下午3:02:30<br/>
 * 
 * 队列服务
 */
public class WorkingService<T extends BaseRequest> {  
    
    private WorkingQueue<T> workingQueue;  
  
    public WorkingService() {  
        workingQueue = new WorkingQueue<T>();  
    }
 
    public void start() {  
        workingQueue.start();  
    }  
  
    public void execute(final T t, LazyExecutable<T> callback ) {  
        t.setLazyExecutor(callback);  
        workingQueue.execute(t);  
    }  
  
    public void stop() {  
        if (workingQueue != null) {  
            workingQueue.stop();  
        }  
    }  
}  