/**
 * 
 */
package com.github.xjs.access.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 下午3:33:10
 */
public class ThreadPoolUtil {
	private final ExecutorService executor;

	private static ThreadPoolUtil instance = new ThreadPoolUtil();

	private ThreadPoolUtil() {
		this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
	}

	public static ThreadPoolUtil getInstance() {
		return instance;
	}

	public static <T> Future<T> execute(final Callable<T> runnable) {
		return getInstance().executor.submit(runnable);
	}

	public static Future<?> execute(final Runnable runnable) {
		return getInstance().executor.submit(runnable);
	}
}
