/**
 * 
 */
package com.github.xjs.access.exception;

import com.github.xjs.access.result.CodeMsg;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月19日 上午10:28:48<br>
 * 
 * 全局的异常，出现业务异常需要抛出，{@link GlobalExceptionHandler}会进行处理
 */
public class BizException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private CodeMsg codeMsg;

	public BizException(CodeMsg codeMsg) {
		this(codeMsg, null);
	}
	
	public BizException(CodeMsg codeMsg, Throwable t) {
		super(codeMsg.getCode()+":"+codeMsg.getMessage(), t);
		this.codeMsg = codeMsg;
	}
	
	public CodeMsg getCodeMsg() {
		return this.codeMsg;
	}
	
}
