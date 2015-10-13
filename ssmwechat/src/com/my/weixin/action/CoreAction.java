package com.my.weixin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.weixin.service.ICoreService;
import com.my.weixin.utils.SignUtil;

@Controller
public class CoreAction extends BaseAction {
	
	@Autowired
	private ICoreService coreService;

	/**
	 * 确认请求来自微信服务器
	 */
	@RequestMapping("/getToken")
	public void getToken(HttpServletRequest request,HttpServletResponse response){
		String method = request.getMethod();
		if (method.equals("GET")) {
			PrintWriter pw = null;
			try {
				pw = response.getWriter();
				//微信加密签名
				String signature = request.getParameter("signature");
				//时间戳
				String timestamp = request.getParameter("timestamp");
				//随机数
				String nonce = request.getParameter("nonce");
				//随机字符串
				String echostr = request.getParameter("echostr");
				
				
				//通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
				if (SignUtil.checkSignature(signature, timestamp, nonce)) {
					pw.print(echostr);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				pw.print("error................................");
			}finally{
				if(pw != null)
					pw.close();
				pw = null;
			}
		}else{
			PrintWriter out = null;
			try {
				System.out.println("method"+method);
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				
				//调用核心Service类接收/处理消息
				String respMessage = coreService.processRequest(request);
				
				//相应消息
				out = response.getWriter();
				out.print(respMessage);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if (out != null) {
					out.close();	
				}
				out = null;
			}
		}
		
	}

}
