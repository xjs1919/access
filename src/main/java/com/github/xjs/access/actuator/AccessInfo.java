/**
 * 
 */
package com.github.xjs.access.actuator;

import org.springframework.web.method.HandlerMethod;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 下午3:04:03
 */
public class AccessInfo {
	private HandlerMethod hm;
	private String uri;
	private long startAt;
	private long endAt;
	private boolean occurError;
	public HandlerMethod getHm() {
		return hm;
	}
	public void setHm(HandlerMethod hm) {
		this.hm = hm;
	}
	public long getStartAt() {
		return startAt;
	}
	public void setStartAt(long startAt) {
		this.startAt = startAt;
	}
	public long getEndAt() {
		return endAt;
	}
	public void setEndAt(long endAt) {
		this.endAt = endAt;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public boolean isOccurError() {
		return occurError;
	}
	public void setOccurError(boolean occurError) {
		this.occurError = occurError;
	}
}
