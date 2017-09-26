/**
 * 
 */
package com.github.xjs.access.util;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月19日 上午9:52:58
 */
public class ValidateUtil {
	
	private static String mobilePattern = "1\\d{10}";
	
	public static boolean isMobile(String mobile) {
		if(StringUtils.isEmpty(mobile)) {
			return false;
		}
		return Pattern.matches(mobilePattern, mobile);
	}
	
}
