/**
 * 
 */
package com.github.xjs.access.result;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月15日 下午12:23:52
 */
public interface ICodeMsg {
	public static final int SUCCESS_CODE = 0;
	public static final String SUCCESS_MSG = "成功";
	public static final int SERVER_ERROR_CODE = 500;
	public static final String SERVER_ERROR_MSG = "服务端异常";
	public int getCode();
	public String getMessage(String... args);
	public ICodeMsg fillArgs(String... args);
}
