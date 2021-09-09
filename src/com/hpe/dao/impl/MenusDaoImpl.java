/**
 * 
 */
package com.hpe.dao.impl;

import com.hpe.dao.IMenusDao;
import com.hpe.pojo.Menus;
import com.hpe.pojo.MenusInfo;
import com.hpe.util.DBUtil;
import com.hpe.util.Page;

/** 
 * 类描述：
 * 作者：yuhui
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public class MenusDaoImpl implements IMenusDao {

	private DBUtil dbutil = new DBUtil();
	@Override
	public Page getMenus(Page page) {
		String sql = "SELECT menus.id as id,menus.name,imgpath,burden,types.name AS typename,"
				+"brief,price,sums,price1,sums1 FROM menus INNER JOIN types "
				+"ON menus.typeid=types.id ";
		Page page1= null;
		page1=dbutil.getQueryPage(MenusInfo.class, sql, null, page);
		
		return page1;
	}
	
	@Override
	public int addMenus(Menus menus) {
		String sql = "INSERT INTO menus(name,burden,price,price1,brief,typeid,imgpath) values(?,?,?,?,?,?,?)";
		Object[] param = {menus.getName(),menus.getBurden(),menus.getPrice(),menus.getPrice1(),menus.getBrief(),menus.getTypeid(),menus.getImgpath()};
		int result=0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}
	
	@Override
	public Menus getMenusByName(String name) {
		String sql ="select * from menus where name =?";
		Object[] param={name};
		Menus menus = null;
		try {
			menus = (Menus) dbutil.getObject(Menus.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return menus;
	}

	
	@Override
	public Menus getMenusById(int id) {
		String sql ="select * from menus where id =?";
		Object[] param={id};
		Menus menus = null;
		try {
			menus = (Menus) dbutil.getObject(Menus.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return menus;
	}

	
	@Override
	public int updateMenus(Menus menus) {
		String sql="update menus set name=? typeid=? burden=?,brief=?,price=?,sums=?,price1=?,sums1=?,imgpath=? where id=?";
		Object[] param={menus.getName(),menus.getTypeid(),menus.getBurden(),menus.getBrief(),menus.getPrice(),menus.getSums(),menus.getPrice1(),menus.getSums1(),menus.getImgpath(),menus.getId()};
		int result=0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
