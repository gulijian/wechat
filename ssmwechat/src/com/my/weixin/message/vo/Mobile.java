package com.my.weixin.message.vo;

/**
 * �ֻ����������ʵ����
 * 
 * @author GULJ
 * @date 2015-05-30
 * 
 */
public class Mobile {

	private String resultcode; // ��Ӧ��

	private String reason; // ����˵��

	private MobileResult result; // ���ؽ����

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
