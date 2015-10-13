package com.my.weixin.message.vo;

/**
 * 手机号码归属地结果集实体类
 * 
 * @author GULJ
 * @date 2015-05-30
 */
public class MobileResult {

	private String province; // 省份

	private String city; // 城市

	private String areacode; // 区号

	private String zip; // 邮编

	private String company; // 运营商

	private String card; // 卡类型

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
}
