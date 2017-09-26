/**
 * 
 */
package com.github.xjs.access.result;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月15日 下午12:21:25
 */
public class Result<T> {
	private int code;
	private String message;
	private T data;
	
	public Result(){
		this((T)null);
	}

	/**
	 * 正常返回
	 * */
	public static <T> Result<T> success(T t){
		return new Result<T>(t);
	}
	
	/**
	 * 异常返回
	 * */
	public static <T> Result<T> error(ICodeMsg codeMsg){
		return new Result<T>(codeMsg);
	}
	
	/**
	 * 异常返回
	 * */
	public static <T> Result<T> error(Result<?> response){
		return new Result<T>(response.getCode(), response.getMessage());
	}
	
	private Result(T data){//正常
		this.code = ICodeMsg.SUCCESS_CODE;
		this.message = ICodeMsg.SUCCESS_MSG;
		this.data = data;
	}
	
	private Result(ICodeMsg codeMsg){//异常
		this.code = codeMsg.getCode();
		this.message = codeMsg.getMessage();
	}
	
	/**
	 * 异常，不让外部使用
	 * */
	private Result(int code, String message){
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public T getData() {
		return data;
	}
}
