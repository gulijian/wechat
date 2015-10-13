package com.my.weixin.service.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.my.weixin.message.resp.TextMessage;
import com.my.weixin.service.ICoreService;
import com.my.weixin.utils.AnswerUtil;
import com.my.weixin.utils.InitAnswerUtil;
import com.my.weixin.utils.Kuaidi100Util;
import com.my.weixin.utils.MessageUtil;
import com.my.weixin.utils.StringUtil;

/**
 * 核心Service
 * 
 * @author gulj 2015-10-3
 * @version 1
 */
@Service
public class CoreService implements ICoreService {
	/**
	 * 日志记录器
	 */
//	private static Logger log = Logger.getLogger(CoreService.class);


	/**
	 * 处理短信发来的请求
	 * 
	 * @param request
	 * @return xml格式的回复消息
	 */
	public String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml 请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);		

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				System.out.println("11111111111111111");
				String Content = requestMap.get("Content");
				if("?".equals(Content) || "？".equals(Content)){
					//主菜单
					respMessage = AnswerUtil.getMainMenu(true,fromUserName,toUserName);
					if(null != respMessage){
						return respMessage;
					}else{
						respContent = AnswerUtil.tulingRobotResp(Content);
					}
				}else if(StringUtil.isRegex(Content.trim(), StringUtil.getqqfaceRegex())){
					respContent=Content.trim();
					if(null == respContent){
						respContent = AnswerUtil.tulingRobotResp(Content);
					}
				}else if("1".equals(Content) || Content.trim().contains("手机")){
					//手机号码使用指南
					respContent = InitAnswerUtil.getinitMoblieAnswer();
				}else if(StringUtil.isRegex(Content.trim(), "^\\d*$") && (Content.trim().length() == 7 || Content.trim().length() == 11)){
					//手机号码归属地回复
					respContent = AnswerUtil.getMobileInfo(Content.trim());
				}else if("2".equals(Content)|| Content.trim().contains("快递")){
					//快递查询使用指南
					respContent = InitAnswerUtil.getInitKuaidiAnswer();
				}else if(Content.trim().contains("#") && Content.trim().length() > 5){
					String[] strs = Content.trim().split("#");
					if(strs.length == 2){
						if(null != strs[0] && null != strs[1]){
							String expressName = strs[0];
							String expressNum = strs[1];
							if(!"".equals(expressName) && !"".equals(expressNum)){
								if(StringUtil.isRegex(expressNum, "^\\d*$")){
									if(expressName.contains("EMS") || expressName.contains("ems")){
										expressName="ems";
										respContent = Kuaidi100Util.getKuaidi100Url(expressName, expressNum);
									}else if(expressName.contains("申通") || expressName.contains("shentong")){
										expressName="shentong";
										respContent = Kuaidi100Util.getKuaidi100Url(expressName, expressNum);
									}else if(expressName.contains("圆通") || expressName.contains("yuantong")){
										expressName="yuantong";
										respContent = Kuaidi100Util.getKuaidi100Url(expressName, expressNum);
									}else if(expressName.contains("中通") || expressName.contains("zhongtong")){
										expressName="zhongtong";
										respContent = Kuaidi100Util.getKuaidi100Url(expressName, expressNum);
									}else if(expressName.contains("汇通") || expressName.contains("huitong")){
										expressName="huitongkuaidi";
										respContent = Kuaidi100Util.getKuaidi100Url(expressName, expressNum);
									}else if(expressName.contains("韵达") || expressName.contains("yunda")){
										expressName="yunda";
										respContent = Kuaidi100Util.getKuaidi100Url(expressName, expressNum);
									}else if(expressName.contains("天天") || expressName.contains("tiantian")){
										expressName="tiantian";
										respContent = Kuaidi100Util.getKuaidi100Url(expressName, expressNum);
									}else if(expressName.contains("顺丰") || expressName.contains("shunfeng")){
										expressName="shunfeng";
										respContent = Kuaidi100Util.getKuaidi100Url(expressName, expressNum);
									}else{
										respContent = "亲，小Y还在成长中，目前支持的快递有EMS、申通、圆通、中通、汇通、韵达、天天、顺丰";
									}
									if(null == respContent){
										respContent = AnswerUtil.tulingRobotResp(Content);
									}
								}else{
									respContent = "亲，快递单号格式有误~";
								}
							}else{
								respContent = AnswerUtil.tulingRobotResp(Content);
							}
						}
					}else{
						respContent = AnswerUtil.tulingRobotResp(Content);
					}
				
				}else if("4".equals(Content)){
					//身份证查询使用指南
					respContent = InitAnswerUtil.getinitIdCardAnswer();
				}else if(StringUtil.isRegex(Content.trim(), "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$")){ 
					//身份证查询
					respContent = AnswerUtil.getIdCard(Content.trim());
				}else if("2".equals(Content)) {
					respContent = "生日快乐";
				}else if("3".equals(Content)) {
					respContent = "想你了";
				}else if("8".equals(Content)){
					respMessage=AnswerUtil.manyNewsMessage(true, fromUserName, toUserName);
					return respMessage;
				} else{
					respContent = AnswerUtil.tulingRobotResp(Content);
				}

			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respMessage = AnswerUtil.getMainMenu(true,fromUserName,toUserName);
					System.out.println("===="+respMessage);
					if(null != respMessage){
						return respMessage;
					}
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息， 因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
				}
			
			}
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
			System.out.println(respMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}

}
