package com.my.weixin.message.resp;

public class Article {

	// ͼ����Ϣ����
	private String Title;
	// ͼ����Ϣ����
	private String Description;
	// ͼƬ���ӣ�֧�� JPG��PNG ��ʽ���Ϻõ�Ч��Ϊ��ͼ 640*320��Сͼ 80*80������ͼƬ
	// ���ӵ�������Ҫ�뿪������д�Ļ��������е� Url һ��
	private String PicUrl;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	// ���ͼ����Ϣ��ת����
	private String Url;
}
