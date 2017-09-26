/**
 * 
 */
package com.github.xjs.access.actuator;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 下午3:30:10
 */
public class MethodAccessInfo {
	private String method;
	private String uri;
	private long invokeCount;
	private long successCount;
	private long errorCount;
	private long minMillSecond;
	private long maxMillSecond;
	private long avgMillSecond;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public long getInvokeCount() {
		return invokeCount;
	}
	public void setInvokeCount(long invokeTimes) {
		this.invokeCount = invokeTimes;
	}
	public long getMinMillSecond() {
		return minMillSecond;
	}
	public void setMinMillSecond(long minMillSecond) {
		this.minMillSecond = minMillSecond;
	}
	public long getMaxMillSecond() {
		return maxMillSecond;
	}
	public void setMaxMillSecond(long maxMillSecond) {
		this.maxMillSecond = maxMillSecond;
	}
	public long getAvgMillSecond() {
		return avgMillSecond;
	}
	public void setAvgMillSecond(long avgMillSecond) {
		this.avgMillSecond = avgMillSecond;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public long getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(long successTimes) {
		this.successCount = successTimes;
	}
	public long getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(long errorTimes) {
		this.errorCount = errorTimes;
	}
}
