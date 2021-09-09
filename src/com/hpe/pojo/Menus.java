package com.hpe.pojo;

/*
 * 菜单实体类
 */
public class Menus {

	private int id;//编号
	private String name;//菜品名称
	private String typeid;//菜品类别编号
	private String burden;//原材料
	private String brief;//简介
	private String price;//市场价
	private String sums;//市场销售数量
	private String price1;//会员价格
	private String sums1;//会员销售数量
	private String imgpath;//图片
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getBurden() {
		return burden;
	}
	public void setBurden(String burden) {
		this.burden = burden;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSums() {
		return sums;
	}
	public void setSums(String sums) {
		this.sums = sums;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public String getSums1() {
		return sums1;
	}
	public void setSums1(String sums1) {
		this.sums1 = sums1;
	}
	
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	
	@Override
	public String toString() {
		return "Menus [id=" + id + ", name=" + name + ", typeid=" + typeid + ", burden=" + burden + ", brief=" + brief
				+ ", price=" + price + ", sums=" + sums + ", price1=" + price1 + ", sums1=" + sums1 + ", imgpath="
				+ imgpath + "]";
	}
	public Menus() {
		super();
	}
	public Menus(int id, String name, String typeid, String burden, String brief, String price, String price1,
			String imgpath) {
		super();
		this.id = id;
		this.name = name;
		this.typeid = typeid;
		this.burden = burden;
		this.brief = brief;
		this.price = price;
		this.price1 = price1;
		this.imgpath = imgpath;
	}
	public Menus(String name, String typeid, String burden, String brief, String price, String price1, String imgpath) {
		super();
		this.name = name;
		this.typeid = typeid;
		this.burden = burden;
		this.brief = brief;
		this.price = price;
		this.price1 = price1;
		this.imgpath = imgpath;
	}
}
