/**
 * 
 */
package com.hpe.dao.impl;

import com.hpe.dao.IUserDao;
import com.hpe.pojo.Admin;
import com.hpe.pojo.Users;
import com.hpe.util.DBUtil;

/** 
 * 类描述：用户dao接口实现类
 * 作者：yuhui
 * 创建日期：2019年9月4日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public class UsersDaoImpl implements IUserDao {

	private DBUtil dbutil = new DBUtil();
	
	@Override
	public Users login(String name, String pwd) {
		String sql = "select * from users where name=? and pwd =?";
		Object[] param = {name,pwd};
		Users user = null;                                            
		try {
			user = (Users) dbutil.getObject(Users.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return user;
	}

	
	@Override
	public int updateUsers(Users user) {
		String sql="UPDATE users SET pwd=?,realname=?,age=?,card=?,address=?,phone=?,email=?,`code`=? WHERE id = 1";
		Object[] param={user.getPwd(),user.getRealname(),user.getAge(),user.getCard(),user.getAddress(),user.getPhone(),user.getEmail(),user.getCode()};
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
	public Users getUsersByName(String name) {
		String sql="select * from users where name=?";
		Object[] param={name};
		Users user= null;
		try {
			user =(Users) dbutil.getObject(Users.class,sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return user;
	}


	
	@Override
	public int registe(Users user) {
		String sql ="INSERT INTO users(id,name,pwd,realname,sex,age,card,address,phone,email,code) "
				+"VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param ={user.getId(),user.getName(),user.getPwd(),user.getRealname(),user.getSex(),user.getAge(),user.getCard(),user.getAddress(),user.getPhone(),user.getEmail(),user.getCode()};
		int result =0;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

}
