package com.my.weixin.utils;


/**
 * 主菜单数字默认回复使用指南
 * @author GULJ
 *
 */
public class InitAnswerUtil {
	
	public static StringBuffer sb = new StringBuffer();
	
	/**
	 * 手机归属地使用指南
	 * @return
	 */
	public static  String getinitMoblieAnswer(){
		sb.setLength(0);  //清空
		sb.append("号码归属地查询指南："+"\n\n");
		sb.append("回复：手机号码"+"\n");
		sb.append("例如：1529505****！"+"\n\n");
		sb.append("回复“？”显示主菜单");
		return sb.toString();
	}
	
	/**
	 * 身份证查询使用指南
	 * @return
	 */
	public static String getinitIdCardAnswer(){
		sb.setLength(0); //清空
		sb.append("身份证查询使用指南："+"\n\n");
		sb.append("回复：身份证号码"+"\n");
		sb.append("例如：3213021991*******9075"+"\n\n");
		sb.append("回复“？”显示主菜单");
		return sb.toString();
	}

	public static String getInitKuaidiAnswer(){
		sb.setLength(0); //清空
		sb.append("快递查询使用指南："+"\n\n");
		sb.append("回复：公司名称#快递号"+"\n");
		sb.append("例如：圆通#100374741502"+"\n");
		sb.append("或者：yuantong#100374741502"+"\n\n");
		sb.append("回复“？”显示主菜单");
		return sb.toString();
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(getinitMoblieAnswer());
	}
	
	
}
