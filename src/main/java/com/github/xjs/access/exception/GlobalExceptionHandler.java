/**
 * 
 */
package com.github.xjs.access.exception;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.xjs.access.actuator.AccessHolder;
import com.github.xjs.access.result.CodeMsg;
import com.github.xjs.access.result.Result;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月19日 下午12:29:57<br/>
 * 
 * 全局的异常处理器，拦截所有的异常，转化成json向外输出
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	 /**
     * 所有异常报错
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)  
    public Result<String> allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception{  
        AccessHolder.accessError();
        if(exception instanceof BizException){
        	exception.printStackTrace();
        	BizException biz = (BizException)exception;
        	return Result.error(biz.getCodeMsg());
        }else if(exception instanceof MethodArgumentNotValidException) {//@Valid
        	MethodArgumentNotValidException ex = (MethodArgumentNotValidException)exception;
        	ObjectError error = ex.getBindingResult().getAllErrors().get(0);
        	String message = error.toString().replaceAll(":.*", ":")+error.getDefaultMessage();
        	CodeMsg cm = (CodeMsg)CodeMsg.PARAMETER_VALADATOR_ERROR.fillArgs(message);
        	return  Result.error(cm);
        }else if(exception instanceof ConstraintViolationException){//@Validated
        	ConstraintViolationException ex = (ConstraintViolationException)exception;
        	Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        	ConstraintViolation<?> violation = violations.iterator().next();
        	String message = violation.getMessage();
        	CodeMsg cm = (CodeMsg)CodeMsg.PARAMETER_VALADATOR_ERROR.fillArgs(message);
        	return  Result.error(cm);
        }else {
        	exception.printStackTrace();
        	return Result.error(CodeMsg.SERVER_ERROR);
        }
    }  
}
