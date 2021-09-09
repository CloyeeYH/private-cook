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

public class Order {

	private int id;//订单编号
	private int userid;//用户编号
	private int menuid;//菜品编号
	private String menusum;//订购数量
	private String times;//下单时间
	private String delivery;//派送状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getMenusum() {
		return menusum;
	}
	public void setMenusum(String menusum) {
		this.menusum = menusum;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public Order(int id, int userid, int menuid, String menusum, String times, String delivery) {
		super();
		this.id = id;
		this.userid = userid;
		this.menuid = menuid;
		this.menusum = menusum;
		this.times = times;
		this.delivery = delivery;
	}
	public Order(int userid, int menuid, String menusum, String times, String delivery) {
		super();
		this.userid = userid;
		this.menuid = menuid;
		this.menusum = menusum;
		this.times = times;
		this.delivery = delivery;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	    
}
