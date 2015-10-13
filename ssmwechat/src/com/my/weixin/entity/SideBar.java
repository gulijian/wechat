package com.my.weixin.entity;

/**
 * 左侧导航实体类
 * @author gulj
 *
 */
public class SideBar {
	
	private int id;
	private String url;
	private String name;
	private int parentId;
	private int parentOrder;
	private String icoclass;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getParentOrder() {
		return parentOrder;
	}
	public void setParentOrder(int parentOrder) {
		this.parentOrder = parentOrder;
	}
	public String getIcoclass() {
		return icoclass;
	}
	public void setIcoclass(String icoclass) {
		this.icoclass = icoclass;
	}
	
}
