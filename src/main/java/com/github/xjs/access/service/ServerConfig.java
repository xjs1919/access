/**
 * 
 */
package com.github.xjs.access.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月8日 下午1:39:58
 */
@Component
@ConfigurationProperties(prefix="server")
public class ServerConfig {
	
	private String env;
	private int port;
	private int smsMaxCount;
	
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getSmsMaxCount() {
		return smsMaxCount;
	}
	public void setSmsMaxCount(int smsMaxCount) {
		this.smsMaxCount = smsMaxCount;
	}
}
