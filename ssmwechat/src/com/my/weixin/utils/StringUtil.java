package com.my.weixin.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String 辅助类
 * @author GULJ
 *
 */
public class StringUtil {
	
	/**
	 * 得到字符的所占字节数
	 * @param str 要计算的字符
	 * @param encode 以那种编码格式计算
	 * 				 ISO8859-1一个中文占一个字节
	 * 				 GBK/GB2312 一个中文字符占2个字节
	 * 				 UTF-8 一个中文字符占3个字节
	 * @return 字符所占字节数
	 */
	public static int getBytesSize(String str,String encode){
		int size = 0;
		try {
			size = str.getBytes(encode).length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return size;
	}
	
	/**
	 * 计算采用utf-8编码方式时字符串所占字节数
	 * @param str
	 * @return
	 */
	public static int getBytesSize(String str){
		return getBytesSize(str, "UTF-8");
	}
	
	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
	
	/**
	 * 正则表达式匹配字符才
	 * @param str 要匹配的字符才
	 * @param regex 正则表达式
	 * @return 匹配结果true or false
	 */
	public static boolean isRegex(String str,String regex){
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}
	
	/**
	 * QQ表情表达式
	 * @param args
	 */
	public static String getqqfaceRegex(){
		String	qqfaceRegex="/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::"+
				"Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,"+
				"@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,"+
				"@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:"+
				"@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer"+
				"|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break"+
				"|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:"+
				"strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>"+
				"|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:ki"+
				"ss|/:<&|/:&>";
		return qqfaceRegex;
	}
	
	
	
	public static void main(String[] args) {
		String str = "234234#sdfegre#sdgrh";
		String regex = "^\\d{6}#\\w*#\\w*$";
		isRegex(str, regex);
	}

}
