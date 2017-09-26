/**
 * 
 */
package com.github.xjs.access.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月19日 上午11:13:12<br/>
 * 
 * 支持方法参数上加验证
 */
@Configuration
public class ValidatorConfig {
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

}
