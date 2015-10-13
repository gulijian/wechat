package com.my.weixin.service;

import javax.servlet.http.HttpServletRequest;

public interface ICoreService {

	/**
	 * 处理微信发来的请求
	 * @param request
	 * @return xml格式的回复消息
	 */
	public String processRequest(HttpServletRequest request);
}
