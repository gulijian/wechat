package com.my.weixin.message.vo;

/**
 * 手机号码归属地实体类
 * 
 * @author GULJ
 * @date 2015-05-30
 * 
 */
public class Mobile {

	private String resultcode; // 响应码

	private String reason; // 返回说明

	private MobileResult result; // 返回结果集

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public MobileResult getResult() {
		return result;
	}

	public void setResult(MobileResult result) {
		this.result = result;
	}
}
