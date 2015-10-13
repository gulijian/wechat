package com.my.weixin.message.vo.menu;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.weixin.utils.WeiXinUtil;

/**
 * 菜单管理器类
 * 
 * @author ywj
 * @date 2013-09-30
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	//易信按钮
	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wx3785e42fcff2cc96";
		// 第三方用户唯一凭证密钥
		String appSecret = "ac6977dbcca6b20c6e2f615ff31743e4";

		// 调用接口获取access_token
		AccessToken at = WeiXinUtil.getAccessToken(appId, appSecret);

		int exitMenu = 0;//0 添加  1删除  执行前手动更改
		
		if(exitMenu == 0){
			if (null != at) {
				// 调用接口创建菜单
				int result = WeiXinUtil.createMenu(getMenu(), at.getToken());
	
				// 判断菜单创建结果
				if (0 == result){
					System.out.println("菜单创建成功！");
					log.info("菜单创建成功！");
				}else{
					System.out.println("菜单创建失败，错误码：" + result);
					log.info("菜单创建失败，错误码：" + result);
				}
			}
		}else if(exitMenu == 1){
			if (null != at) {
				// 调用接口删除菜单
				int result = WeiXinUtil.deleteMenu(at.getToken());
	
				// 判断菜单删除结果
				if (0 == result){
					System.out.println("菜单删除成功！");
					log.info("菜单删除成功！");
				}else{
					System.out.println("菜单删除失败，错误码：" + result);
					log.info("菜单删除失败，错误码：" + result);
				}
			}
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		ViewButton  btn11 = new ViewButton ();
		btn11.setName("个人简介");
		btn11.setType("view");
		btn11.setUrl("http://i.eqxiu.com/s/Im4kEoxQ");

		CommonButton btn12 = new CommonButton();
		btn12.setName("个人中心");
		btn12.setType("click");
		btn12.setKey("12");
		
		

		
//		CommonButton btn13 = new CommonButton();
//		btn13.setName("彩票查询");
//		btn13.setType("click");
//		btn13.setKey("13");
		
		CommonButton btn14 = new CommonButton();
		btn14.setName("主页");
		btn14.setType("click");
		btn14.setKey("14");
		
		

//		CommonButton btn21 = new CommonButton();
//		btn21.setName("笑口常开");
//		btn21.setType("click");
//		btn21.setKey("21");
		
		CommonButton btn22 = new CommonButton();
		btn22.setName("在线音乐");
		btn22.setType("click");
		btn22.setKey("22");
		
		CommonButton btn23 = new CommonButton();
		btn23.setName("周公解梦");
		btn23.setType("click");
		btn23.setKey("23");

		CommonButton btn24 = new CommonButton();
		btn24.setName("了解历史");
		btn24.setType("click");
		btn24.setKey("24");
		
		CommonButton btn31 = new CommonButton();
		btn31.setName("微社区");
		btn31.setType("click");
		btn31.setKey("31");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("认识我");
		mainBtn1.setSub_button(new Button[] { btn11, btn12 ,btn14});

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("悦生活");
		mainBtn2.setSub_button(new Button[] { btn22, btn23 ,btn24});
		
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("更多");
		mainBtn3.setSub_button(new Button[] {btn31});
		
		
		/**
		 * 这是公众号JinrunWeixin目前的菜单结构，每个一级菜单都有二级菜单项<br>
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“通话查询”，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn14 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2,mainBtn3});

		return menu;
	}
}