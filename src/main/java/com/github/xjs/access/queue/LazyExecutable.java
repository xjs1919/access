package com.github.xjs.access.queue;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 下午3:02:30<br/>
 * 
 * 队列元素出队的回调必须实现这个接口
 */
public interface LazyExecutable<T extends BaseRequest> {
	public void lazyExecute(T request);
}