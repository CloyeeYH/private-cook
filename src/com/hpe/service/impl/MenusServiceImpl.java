/**
 * 
 */
package com.hpe.service.impl;

import com.hpe.dao.IMenusDao;
import com.hpe.dao.impl.MenusDaoImpl;
import com.hpe.pojo.Menus;
import com.hpe.pojo.Types;
import com.hpe.service.IMenusService;
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

public class MenusServiceImpl implements IMenusService {

	private IMenusDao menusDao= new MenusDaoImpl();
	@Override
	public Page getMenus(Page page) {
		
		return menusDao.getMenus(page);
	}
	
	@Override
	public int addMenus(Menus menus) {
		Menus menu = menusDao.getMenusByName(menus.getName());
		if(menu!=null){
			return -1;
		}
		return menusDao.addMenus(menus);
	}

	
	@Override
	public Menus getMenusById(int id) {
		
		return menusDao.getMenusById(id);
	}

	
	@Override
	public int updateMenus(Menus menus) {
		Menus menu =menusDao.getMenusByName(menus.getName());
		if(menu!=null){
			return -1;
		}
		return menusDao.updateMenus( menus);
	}

}
