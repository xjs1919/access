/**
 * 
 */
package com.github.xjs.access.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月15日 上午11:12:37
 */
public class MD5Util {
	
	public static String md5(String src) {
		return DigestUtils.md5Hex(src);
	}
	
}
