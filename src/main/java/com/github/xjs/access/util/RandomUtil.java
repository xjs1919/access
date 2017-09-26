/**
 * 
 */
package com.github.xjs.access.util;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月15日 下午12:36:37
 */
@SuppressWarnings("deprecation")
public class RandomUtil {
	
	public static int randomInt() {
		return RandomUtils.nextInt();
	}
	
	public static int randomInt(int fromInclude, int toExclude ) {
		return RandomUtils.nextInt(fromInclude, toExclude);
	}
	
	public static long randomLong() {
		return RandomUtils.nextLong();
	}
	
	public static long randomLong(long fromInclude, long toExclude ) {
		return RandomUtils.nextLong(fromInclude, toExclude);
	}
	
	public static String randomString(int count) {
		return RandomStringUtils.random(count);
	}
	
	public static String randomAscii(final int count) {
        return RandomStringUtils.randomAscii(count);
    }
	
	public static String randomAlphabetic(final int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }
	
	public static String randomAlphanumeric(final int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }
	
	public static String randomNumeric(int count) {
		return RandomStringUtils.randomNumeric(count);
	}
	
	
	
}
