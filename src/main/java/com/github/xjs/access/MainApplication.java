package com.github.xjs.access;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月14日 下午4:32:17
 */
@SpringBootApplication
@EnableSwagger2
public class MainApplication {
    public static void main(String[] args) throws Exception {
       	SpringApplication.run(MainApplication.class, args);
    }
}