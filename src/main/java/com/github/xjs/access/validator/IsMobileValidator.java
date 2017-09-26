/**
 * 
 */
package com.github.xjs.access.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Service;

import com.github.xjs.access.util.ValidateUtil;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 上午8:52:19<br/>
 * 
 * JSR303扩展，验证手机号{@link IsMobile}的具体实现
 */
@Service
public class IsMobileValidator implements ConstraintValidator<IsMobile, String>{
	
	@Override
	public void initialize(IsMobile constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(String mobile, ConstraintValidatorContext context) {
		return ValidateUtil.isMobile(mobile);
	}

}
