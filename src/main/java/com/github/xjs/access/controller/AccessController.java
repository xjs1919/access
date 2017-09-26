package com.github.xjs.access.controller;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.xjs.access.actuator.AccessAble;
import com.github.xjs.access.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月14日 下午4:32:17
 */
@RestController
@RequestMapping(value = "/demo")
@Api(tags={"记录应用访问信息"})
public class AccessController implements AccessAble{
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ApiOperation(value="HelloWorld入门")
	public Result<String> helloWorld(HttpServletResponse response) throws Exception{
		return Result.success("hello,world");
	}
}