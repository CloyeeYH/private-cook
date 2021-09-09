/**
 * 
 */
package com.hpe.service;

import com.hpe.pojo.Menus;
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

public interface IMenusService {
	/**
	 * 
	 * 方法描述：分页查询
	 * @param page
	 * @return 分页后的数据
	 */
	Page getMenus(Page page);
	/**
	 * 
	 * 方法描述：添加新菜品
	 * @param menus 
	 * @return 影响的行数
	 */
	int addMenus(Menus menus);
	
	/**
	 * 
	 * 方法描述：根据id查询
	 * @param id
	 * @return 菜品信息
	 */
	Menus getMenusById(int id);
	/**
	 * 
	 * 方法描述：修改菜单
	 * @param menus
	 * @return
	 */
	int updateMenus(Menus menus);
}
