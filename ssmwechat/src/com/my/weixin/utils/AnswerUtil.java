package com.my.weixin.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.my.weixin.message.resp.Article;
import com.my.weixin.message.resp.NewsMessage;
import com.my.weixin.message.vo.IdCard;
import com.my.weixin.message.vo.Mobile;
import com.my.weixin.message.vo.TulingRobot;

public class AnswerUtil {
	/**
	 * 得到主菜单
	 * @return 返回主菜单
	 */
	public static String getMainMenu(String weChatId,String toUserName){
		return getMainMenu(false,weChatId,toUserName);
	}
	
	
	/**
	 * 得到主菜单
	 * @return 返回主菜单
	 */
	public static String getMainMenu(boolean foloow,String fromUserName,String toUserName){
		StringBuffer sb = new StringBuffer();
		if (foloow) {
			sb.append("您好，感谢您的关注，我是小Y：\n");
		}else{
			sb.append("您好，我是小Y：\n");
		}
		sb.append("现为您提供以下服务\n");
		sb.append("-------------\n");
		sb.append("【1】  号码归属地：发送“手机号码”小Y会帮您查手机号码的详细信息哦~\n\n");
		sb.append("【2】  快递查询：发送“快递公司名称#快递单号”查询物流信息\n\n");
		sb.append("【3】  天气查询：发送”XX天气“查询您想了解的地区的天气。例如：”上海天气“ \n\n");
		sb.append("【4】  身份证查询：发送”身份证号码“小Y会帮您查手机号码的详细信息哦~ \n\n");
		sb.append("【5】  笑口常开：发送”笑话“两个字试试吧、 \n\n");
		sb.append("【6】  了解历史：发送”今天“两个字，了解历史上的今天、 \n\n");
		sb.append("【7】  智能聊天：无聊？快来和小Y聊天吧！ \n");
	    sb.append("回复“?”显示此帮助菜单/::)");
	    List<Article> articleList = new ArrayList<Article>();
		 Article article = new Article();
		 article.setTitle("小Y快讯");
		 article.setDescription(sb.toString());
		 article.setPicUrl("http://guljweixin.sinaapp.com/images/titlePage.jpg");
		 article.setUrl("http://www.baidu.com");
		 articleList.add(article);
		return AnswerUtil.imgmessage(fromUserName, toUserName, articleList);
	}
	
	/**
	 * 图文消息
	 * @param fromUserName
	 * @param toUserName
	 * @param type 1.单图文消息  2.单图文消息---不含图片
	 * 			   3.多图文消息  4.多图文消息---首条消息不含图片 
	 * 			   5.多图文消息---最后一条消息不含图片
	 * @return
	 */
	public static String imgmessage(String fromUserName,String toUserName,List<Article> articleList){
		String respMessage = null;
		try {
			// 创建图文消息
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setToUserName(fromUserName);
			newsMessage.setFromUserName(toUserName);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			newsMessage.setFuncFlag(1);
			
			//图文消息中可以使用QQ表情、符号表情    emoji(0x1F6B9)
			
			// 设置图文消息个数
			newsMessage.setArticleCount(articleList.size());
			// 设置图文消息包含的图文集合
			newsMessage.setArticles(articleList);
			// 将图文消息对象转换成xml字符串
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
	
	
	//多图文消息
	public static String manyNewsMessage(boolean foloow,String fromUserName,String toUserName){
		
		  List<Article> articleList = new ArrayList<Article>();
			 Article article1 = new Article();
			 article1.setTitle("大图文");
			 article1.setDescription("ddddd");
			 article1.setPicUrl("http://guljweixin.sinaapp.com/images/titlePage.jpg");
			 article1.setUrl("http://www.baidu.com");
			 articleList.add(article1);
			 Article article2 = new Article();
			 article2.setTitle("小图文一");
			 article2.setDescription("呵呵呵呵呵呵呵");
			 article2.setPicUrl("http://guljweixin.sinaapp.com/images/chushi.jpg");
			 article2.setUrl("http://www.baidu.com");
			 articleList.add(article2);
			 Article article3 = new Article();
			 article3.setTitle("小图文二");
			 article3.setDescription("发送即可发货爱妃深咖啡喝酒啊绥芬河");
			 article3.setPicUrl("http://guljweixin.sinaapp.com/images/chaoshi.jpg");
			 article3.setUrl("http://www.baidu.com");
			 articleList.add(article3);
			 Article article4 = new Article();
			 article4.setTitle("小图文三");
			 article4.setDescription("中国是一个强国");
			 article4.setPicUrl("http://guljweixin.sinaapp.com/images/chushi.jpg");
			 article4.setUrl("http://www.baidu.com");
			 articleList.add(article4);

			 return AnswerUtil.imgmessage(fromUserName, toUserName, articleList);
	}
	
	/**
	 * 手机号查询归属地
	 * @param mobile
	 * 			手机号码
	 * @return
	 */
	public static String getMobileInfo(String mobile){
		QueryCallBackUtil qback = new QueryCallBackUtil();
		String str = qback.getmobileArea(mobile);
		Gson gson = new GsonBuilder().create();
		Type fansCount = new TypeToken<Mobile>() {}.getType();
		Mobile fans = gson.fromJson(str, fansCount);
		StringBuffer sb = new StringBuffer();
		if(null != fans){
			if("200".equals(fans.getResultcode())){
				sb.append("手机号："+mobile+"\n");
				sb.append("运营商："+fans.getResult().getCompany()+"\n");
				sb.append("省份："+fans.getResult().getProvince()+"\n");
				sb.append("城市："+fans.getResult().getCity()+"\n");
				sb.append("区号："+fans.getResult().getAreacode()+"\n");
				sb.append("邮编："+fans.getResult().getZip()+"\n");
				sb.append("卡类型："+fans.getResult().getCard());
			}else{
				sb.append("请求处理异常，请稍候重试！");
			}
		}else{
			sb.append("请求处理异常，请稍候重试！");
		}
		return sb.toString();
	}
	
	/**
	 * 身份证查询
	 * @param idCard
	 * 		   身份证号码
	 * @return
	 */
	public static String getIdCard(String idCard){
		QueryCallBackUtil qback = new QueryCallBackUtil();
		String str = qback.getIdCard(idCard);
		System.out.println(str);
		Gson gson = new GsonBuilder().create();
		Type fansCount = new TypeToken<IdCard>() {}.getType();
		IdCard fans = gson.fromJson(str, fansCount);
		System.out.println("=="+fans);
		StringBuffer sb = new StringBuffer();
		if(null != fans){
			if("200".equals(fans.getResultcode())){
				sb.append("地区："+fans.getResult().getArea()+"\n");
				sb.append("性别："+fans.getResult().getSex()+"\n");
				sb.append("生日："+fans.getResult().getBirthday()+"\n");
			}else{
				sb.append("请求处理异常，请稍候重试！");
			}
		}else{
			sb.append("请求处理异常，请稍候重试！");
		}
		return sb.toString();
	}
	
	/**
	 * 图灵机器人智能回复
	 * @param args
	 */
	
	public static String tulingRobotResp(String Content){
		TulingRobotUtil tuling = new TulingRobotUtil();
		String str = tuling.getTulingText(Content);
		Gson gson = new GsonBuilder().create();
		Type fansCount = new TypeToken<TulingRobot>() {}.getType();
		TulingRobot fans = gson.fromJson(str, fansCount);
		StringBuffer sb = new StringBuffer();
		if(null != fans){
			if("100000".equals(fans.getCode())){
				sb.append(fans.getText());
			}else{
				sb.append("请求处理异常，请稍候重试！");
			}
			
		}else{
			sb.append("请求处理异常，请稍候重试！");
		}
		return sb.toString();
	}
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(tulingRobotResp("中国是一个强大的国家吗"));
	}
	
	
	
	
}
