/**
 * 
 */
package com.hpe.pojo;

/** 
 * 类描述：
 * 作者：yuhui
 * 创建日期：2019年9月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public class OrdersInfo {
	private int userid; //用户编号
	private String menuname;//菜品名
	private String date;//日期
	private int delivery;//派送状态
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date1) {
		this.date = date1;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	

}
