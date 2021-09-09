/**
 * 
 */
package com.hpe.service.impl;

import com.hpe.dao.IAdminDao;
import com.hpe.dao.impl.AdminDaoImpl;
import com.hpe.pojo.Admin;
import com.hpe.service.IAdminService;

/** 
 * 类描述：管理员service接口实现类
 * 作者：yuhui
 * 创建日期：2019年9月2日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public class AdminServiceImpl implements IAdminService {
	
	private IAdminDao adminDao = new AdminDaoImpl();
	@Override
	public Admin login(String name, String pwd) {
		
		return adminDao.login(name, pwd);
	}
	
	@Override
	public Admin getAdminByName(String name) {
		// TODO Auto-generated method stub
		return adminDao.getAdminByName(name);
	}
	
	@Override
	public int updateAdmin(Admin admin) {
		Admin admin1 = adminDao.getAdminByName(admin.getName());
		if(admin1!=null&&admin1.getName().equals(admin.getName())&&admin1.getId()!=admin.getId()){
			return-1;
		}
		return adminDao.updateAdmin(admin);
	}
	

}
