package com.my.weixin.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 图灵机器人
 * @author GULJ
 *
 */
public class TulingRobotUtil {
	
	public  String getTulingText(String Content) {
		try {
			final int TIME_OUT = 30000;
			String APIKEY = "5dd7e8d3c6a1aadafbab323df1dc5fc7";
			String INFO = URLEncoder.encode(Content, "utf-8");
			String getURL = "http://www.tuling123.com/openapi/api?key="+ APIKEY + "&info=" + INFO;
			URL postUrl = new URL(getURL);
			HttpURLConnection connection = (HttpURLConnection) postUrl
					.openConnection();
			// 超时连接
			connection.setConnectTimeout(TIME_OUT);
			;
			// 超读时间
			connection.setReadTimeout(TIME_OUT);
			// 请求方法post请求
			connection.setRequestMethod("GET");
			// 系统自动处理重定向
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			// connection.setRequestProperty("User-Agent",
			// "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36");
			// 连接
			connection.connect();

			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));
			// 返回数据
			String response = "";
			String readLine = null;
			while ((readLine = br.readLine()) != null) { // 读取数据
				response = response + readLine;
			}
			is.close();
			br.close(); // 关闭流
			connection.disconnect(); // 关闭连接
			return response;
		} catch (Exception e) { // 返回数据
			e.printStackTrace();
		}
		return null;

	}
	

}
