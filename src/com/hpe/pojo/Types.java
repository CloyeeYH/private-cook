/**
 * 
 */
package com.hpe.pojo;

/** 
 * 类描述：
 * 作者：yuhui
 * 创建日期：2019年9月3日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public class Types {

	private int id;
	private String name;
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
	@Override
	public String toString() {
		return "Types [id=" + id + ", name=" + name + "]";
	}
	
}
