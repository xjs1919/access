/**
 * 
 */
package com.github.xjs.access.util;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月15日 上午11:12:56
 */
public class IDUtil {
	public static String getId() {
		return MD5Util.md5(UUIDUtil.uuid());
	}
}
