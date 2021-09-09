/**
 * 
 */
package com.hpe.pojo;

/** 
 * 类描述：购物车实体类
 * 作者：yuhui
 * 创建日期：2019年9月5日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public class ShoppingCart {

	private int menuid;//菜品id
	private String name; //菜品名
	private float price;//价格
	private int sum;//数量
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
}
