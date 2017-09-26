/**
 * 
 */
package com.github.xjs.access.result;

/**
 * @author 605162215@qq.com
 *
 * @date 2017年9月15日 下午12:27:58
 */
public class CodeMsg implements ICodeMsg{
	
	public static CodeMsg SUCCESS = new CodeMsg(ICodeMsg.SUCCESS_CODE, ICodeMsg.SUCCESS_MSG);
	public static CodeMsg SERVER_ERROR = new CodeMsg(ICodeMsg.SERVER_ERROR_CODE, ICodeMsg.SERVER_ERROR_MSG);
	//添加其他的错误码和错误信息
	public static CodeMsg PARAMETER_VALADATOR_ERROR = new CodeMsg(500100,"参数校验异常：%s");//参数检验异常 
	public static CodeMsg REGISTER_INFO_EMPTY = new CodeMsg(500101,"注册信息不能为空");
	public static CodeMsg PHONE_OPENID_EMPTY = new CodeMsg(500102,"手机号码与微信ID不能同时为空");
	public static CodeMsg PHONE_FORMAT_ERROR = new CodeMsg(500103,"手机号码格式有误");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500104,"密码不能为空");
	public static CodeMsg PASSWORD_TOO_LONG = new CodeMsg(500105,"密码太长");
	public static CodeMsg BEAN_COPY_ERROR = new CodeMsg(500106,"Bean复制异常");
	public static CodeMsg PHONE_EXIST = new CodeMsg(500107,"手机号码已经存在");
	public static CodeMsg OPEN_ID_EXIST= new CodeMsg(500108,"微信OpenID已经存在");
	public static CodeMsg PHONE_NOT_EXIST = new CodeMsg(500109,"手机号码不存在");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500110,"密码错误");
	public static CodeMsg OPEN_ID_NOT_EXIST= new CodeMsg(500111,"微信OpenID不存在");
	public static CodeMsg TOKEN_EMPTY= new CodeMsg(500112,"无法获取TOKEN");
	public static CodeMsg TOKEN_ERROR= new CodeMsg(500113,"TOKEN不存在或者已经失效");
	public static CodeMsg USER_NOT_EXIST= new CodeMsg(500114,"用户不存在");
	public static CodeMsg SMS_SEND_LIMIT_ERROR= new CodeMsg(500115,"验证码发送次数今日已达上限");
	public static CodeMsg SMS_VERIFY_CODE_EXPIRE= new CodeMsg(500116,"验证码不存在或者已经失效");
	public static CodeMsg SMS_VERIFY_CODE_ERROR= new CodeMsg(500117,"验证码错误");
	;
	
	
	private int code;
	private String message;
	private CodeMsg(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	@Override
	public int getCode() {
		return code;
	}
	
	@Override
	public String getMessage(String... args) {
		if(args == null || args.length <= 0) {
			return message;
		}
		return String.format(message, (Object[])args);
	}
	
	public ICodeMsg fillArgs(String... args) {
		if(args == null || args.length <= 0) {
			return this;
		}
		int code = this.code;
		String message = getMessage(args);
		return new CodeMsg(code, message);
	}
	
}
