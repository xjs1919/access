/**
 * 
 */
package com.github.xjs.access.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 上午10:27:27<br>
 * 
 * 注册拦截器
 */
@Configuration
public class CaWebMvcConfigurer extends WebMvcConfigurerAdapter {
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
    
}