/**
 * 
 */
package com.hpe.dao;

import com.hpe.pojo.Admin;

/** 
 * 类描述：管理员dao接口
 * 作者：yuhui
 * 创建日期：2019年9月2日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public interface IAdminDao {
	/**
	 * 
	 * 方法描述：管理员登陆
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 管理员信息
	 */
	Admin login(String name, String pwd);
	/**
	 * 
	 * 方法描述：管理员信息修改
	 * @param admin 用户名   
	 * @param id 密码
	 * @return 影响的行数
	 */
	int updateAdmin(Admin admin);
	/**
	 * 
	 * 方法描述：根据用户名查询
	 * @param name 用户名   
	 * @return 管理员信息
	 */
	Admin getAdminByName(String name);
	
}
