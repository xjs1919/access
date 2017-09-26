/**
 * 
 */
package com.github.xjs.access.actuator;

import com.github.xjs.access.queue.BaseRequest;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月21日 下午5:19:23
 */
public class AccessRequest extends BaseRequest{
	private AccessInfo ai;
	public AccessRequest(AccessInfo ai) {
		super();
		this.ai = ai;
	}

	public AccessInfo getAi() {
		return ai;
	}

	public void setAi(AccessInfo ai) {
		this.ai = ai;
	}
	
}
