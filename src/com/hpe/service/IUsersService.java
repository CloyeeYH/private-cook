/**
 * 
 */
package com.hpe.service;

import com.hpe.pojo.Admin;
import com.hpe.pojo.Users;

/** 
 * 类描述：用户service接口
 * 作者：yuhui
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public interface IUsersService {

	/**
	 * 
	 * 方法描述：用户登陆
	 * @param name 用户名
	 * @param pwd 用户密码
	 * @return 用户信息
	 */
	Users login(String name,String pwd);
	/**
	 * 
	 * 方法描述：根据用户名查询
	 * @param name 用户名   
	 * @return 用户信息
	 */
	Users getUsersByName(String name);
	/**
	 * 
	 * 方法描述：用户信息修改
	 * @param admin 用户名   s
	 * @param id 密码
	 * @return 影响的行数
	 */
	int updateUsers(Users user);
	
	/**
	 * 
	 * 方法描述：用户注册
	 * @param user
	 * @return 影响的行数
	 */
	int registe(Users user);
}
