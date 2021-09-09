/**
 * 
 */
package com.hpe.dao.impl;

import com.hpe.dao.IAdminDao;
import com.hpe.pojo.Admin;
import com.hpe.util.DBUtil;

/** 
 * 类描述：管理员dao接口实现类
 * 作者：yuhui
 * 创建日期：2019年9月2日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public class AdminDaoImpl implements IAdminDao {
	
	private DBUtil dbutil = new DBUtil();
	
	
	@Override
	public Admin login(String name, String pwd) {
		// SQL语句
		String sql="select * from admin where name=? and pwd=?";
		//参数列表
		Object[] param={name,pwd};
		//定义实体类接受数据库返回结果
		Admin admin = null;
		try {
			//执行查询
			admin = (Admin) dbutil.getObject(Admin.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//返回查询结果
		return admin;
	}


	@Override
	public int updateAdmin(Admin admin) {
		String sql="update admin set name=?,pwd=? where id =?";
		Object[] param={admin.getName(),admin.getPwd(),admin.getId()};
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
	public Admin getAdminByName(String name) {
		String sql="select * from admin where name=?";
		Object[] param={name};
		Admin admin = null;
		try {
			admin =(Admin) dbutil.getObject(Admin.class,sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return admin;
	}
	
	

}
