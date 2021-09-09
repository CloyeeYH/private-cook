/**
 * 
 */
package com.hpe.service.impl;

import com.hpe.dao.IUserDao;
import com.hpe.dao.impl.UsersDaoImpl;
import com.hpe.pojo.Admin;
import com.hpe.pojo.Users;
import com.hpe.service.IUsersService;

/** 
 * 类描述：用户Service接口实现类
 * 作者：yuhui
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public class UsersServiceImpl implements IUsersService {

	private IUserDao usersDao = new UsersDaoImpl();
	@Override
	public Users login(String name, String pwd) {
		
		return usersDao.login(name, pwd);
	}
	
	@Override
	public Users getUsersByName(String name) {
		
		return usersDao.getUsersByName(name);
	}
	
	@Override
	public int updateUsers(Users user) {
		Users users = usersDao.getUsersByName(user.getName());
		if(users!=null&&user.getName().equals(users.getName())&&users.getId()!=user.getId()){
			return-1;
		}
		return usersDao.updateUsers(user);
	}

	
	@Override
	public int registe(Users user) {
		Users users = usersDao.getUsersByName(user.getName());
		if(users!=null){
			return -1;
		}
		return usersDao.registe(user);
	}

}
