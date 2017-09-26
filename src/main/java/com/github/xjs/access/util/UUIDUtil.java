/**
 * 
 */
package com.github.xjs.access.util;

import java.util.UUID;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月15日 上午11:12:50
 */
public class UUIDUtil {
	
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
