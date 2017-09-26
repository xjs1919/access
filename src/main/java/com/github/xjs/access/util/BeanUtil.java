/**
 * 
 */
package com.github.xjs.access.util;
import org.apache.commons.beanutils.BeanUtils;

import com.github.xjs.access.exception.BizException;
import com.github.xjs.access.result.CodeMsg;
/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月19日 上午10:13:40
 */
public class BeanUtil {
	
	public static <Src, Dst> Dst copyBean(Src src, Class<Dst> dstClazz) {
		Dst dst = null;
		try {
			dst = dstClazz.newInstance();
			BeanUtils.copyProperties(dst, src);
			return dst;
		}catch(Exception e) {
			throw new BizException(CodeMsg.BEAN_COPY_ERROR, e);
		}
	} 
	
	public static <Src, Dst> void copyBean(Src src, Dst dst) {
		try {
			BeanUtils.copyProperties(dst, src);
		}catch(Exception e) {
			throw new BizException(CodeMsg.BEAN_COPY_ERROR, e);
		}
	} 
}
