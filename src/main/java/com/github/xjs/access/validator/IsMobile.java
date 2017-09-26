/**
 * 
 */
package com.github.xjs.access.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload; 
/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 上午8:48:05<br/>
 * 
 * JSR303扩展，验证手机号
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
@Constraint(validatedBy = IsMobileValidator.class)
public @interface IsMobile {
	
    String message() default "手机号码格式有误";  
    
    Class<?>[] groups() default {};  
    
    Class<? extends Payload>[] payload() default {};  
}
