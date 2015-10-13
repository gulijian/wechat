package com.my.weixin.utils;

public class Kuaidi100Util {
	
	
	public static String getKuaidi100Url(String code,String kuaidiNum){
		  String getURL = "http://m.kuaidi100.com/index_all.html?type="+code+"&postid="+kuaidiNum+"";
		  return getURL;
	}
	

}
