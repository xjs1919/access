/**
 * 
 */
package com.github.xjs.access.actuator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月26日 上午9:43:25<br/>
 */
@Configuration
public class EndPointAutoConfig {
	
    @Bean
    public AccessEndPoint myEndPoint() {
        return new AccessEndPoint();
    }
  
}
