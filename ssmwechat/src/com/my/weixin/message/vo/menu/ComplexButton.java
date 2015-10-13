package com.my.weixin.message.vo.menu;

/**
 * 复杂按钮（父按钮）
 * 
 * @author ywj
 * @date 2013-09-30
 */
public class ComplexButton extends Button {
	private Button[] sub_button;

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
