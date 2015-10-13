package com.my.weixin.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 获取网上数据返回json格式
 * @author GULJ
 *
 */
public class QueryCallBackUtil {
	
	/**
	 * 查询手机号码归属地
	 * @param mobile
	 * 			手机号码
	 * @return
	 */
	public  String getmobileArea(String mobile){
		final int TIME_OUT=30000;
		//请求url
		String httpUrl="http://apis.juhe.cn/mobile/get?";
		//请求参数
		String httpUrlParameters="phone="+mobile+"&key="+JuheAppKeyUtil.mobile+"";
		
		try {
				URL postUrl = new URL(httpUrl+httpUrlParameters);
				HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
				//超时连接
				connection.setConnectTimeout(TIME_OUT);;
				//超读时间
				connection.setReadTimeout(TIME_OUT);
				//post请求需要设置
				connection.setDoOutput(true);
				//请求方法post请求
				connection.setRequestMethod("POST");
				//系统自动处理重定向
				connection.setInstanceFollowRedirects(true);
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		//		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36");
				//连接
				connection.connect();
				
				InputStream is = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				//返回数据
				String response = ""; 
				String readLine = null;
				while((readLine = br.readLine())!=null){ //读取数据
					 response = response + readLine;	
				}
				is.close();
				br.close();              //关闭流
				connection.disconnect(); //关闭连接
				return response;
		} catch (Exception e) {          //返回数据    
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 身份证查询
	 * @param idCard
	 * 			身份证号码
	 * @return
	 */
	public  String getIdCard(String idCard){
		final int TIME_OUT=30000;
		//请求url
		String httpUrl="http://apis.juhe.cn/idcard/index?";
		//请求参数
		String httpUrlParameters="cardno="+idCard+"&key="+JuheAppKeyUtil.idcard+"";
		
		try {
				URL postUrl = new URL(httpUrl+httpUrlParameters);
				HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
				//超时连接
				connection.setConnectTimeout(TIME_OUT);;
				//超读时间
				connection.setReadTimeout(TIME_OUT);
				//请求方法post请求
				connection.setRequestMethod("GET");
				//系统自动处理重定向
				connection.setInstanceFollowRedirects(true);
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		//		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36");
				//连接
				connection.connect();
				
				InputStream is = connection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				//返回数据
				String response = ""; 
				String readLine = null;
				while((readLine = br.readLine())!=null){ //读取数据
					 response = response + readLine;	
				}
				is.close();
				br.close();              //关闭流
				connection.disconnect(); //关闭连接
				return response;
		} catch (Exception e) {          //返回数据    
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		//System.out.println(getIdCard("32130219911215705X"));
	}
	
	
	
}




