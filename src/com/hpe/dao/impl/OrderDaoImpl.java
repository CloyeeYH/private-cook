/**
 * 
 */
package com.hpe.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hpe.dao.IOrderDao;
import com.hpe.pojo.Order;
import com.hpe.pojo.Orders;
import com.hpe.pojo.OrdersInfo;
import com.hpe.util.DBUtil;
import com.hpe.util.Page;

/** 
 * 类描述：
 * 作者：yuhui
 * 创建日期：2019年9月6日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public class OrderDaoImpl implements IOrderDao {

	private DBUtil dbutil = new DBUtil();
	@Override
	public int addOrder(Order order) {
		String sql="insert into orders(menuid,userid,menusum,times,delivery) values(?,?,?,?,?)";
		Object[] param = {order.getMenuid(),order.getUserid(),order.getMenusum(),order.getTimes(),order.getDelivery()};
		int result =0;
		try {
			result = dbutil.execute(DBUtil.getConnection(), sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}
	
	@Override
	public Page getOrderSearch(Page page, OrdersInfo ordersInfo) {
		String sql = "SELECT users.id as userid,realname,phone,address,menus.name as menuname,menusum,price1,times,delivery from orders " 
				+"INNER JOIN menus on menus.id=orders.menuid " 
				+"INNER JOIN users ON orders.userid = users.id "
				+"where 1=1";
		List<Object> list = new ArrayList<Object>();
		if(ordersInfo!=null){
			int userid = ordersInfo.getUserid();
			if (userid>0) {
				sql=sql+" AND users.id=?";
				list.add(userid);
			}
			String menuname = ordersInfo.getMenuname();
			if(menuname!=null&&menuname.length()>0){
				sql+=" AND menus.name like ?";
				list.add("%"+menuname+"%");
			}
			String date =ordersInfo.getDate();
			if(date!=null&&date.length()>0){
				sql+=" and times like ?";
				list.add("%"+date+"%");
			}
			int delivery =ordersInfo.getDelivery();
			if(delivery>=0&&delivery<=1){
				sql+=" and delivery=?";
				list.add(delivery);
			}
			
		}
		sql+=" order by times desc";
		Page page1= dbutil.getQueryPage(Orders.class, sql, list.toArray(), page);
		return page1;
	}

	


	
	@Override
	public int ensure(int id) {
		String sql = "update orders set delivery=1 where id=?";
		Object[] param  = {id};
		int result =0 ;
		try {
			result = dbutil.execute(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	
	@Override
	public List<Orders> statistic() {
		String sql = "SELECT menus.name,sums1,price1,(sums1*price1) as total from orders INNER JOIN menus "
					+" ON menus.id=orders.menuid "
					+" where orders.times like ?";
		
		Object[] param ={new Date()};
		List list = null;
		try {
			list = dbutil.getQueryList(Orders.class, sql, param);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	
	@Override
	public Page getOrders(Page page) {
		String sql="SELECT users.id as userid,realname,phone,address,menus.name as menuname,menusum,price1,times,delivery from orders " 
				+"INNER JOIN menus on menus.id=orders.menuid " 
				+"INNER JOIN users ON orders.userid = users.id ";
		Page page1 =null;
		List list =null;
		try {
			list = dbutil.getQueryList(Orders.class, sql, null);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		page1=dbutil.getQueryPage(OrdersInfo.class, sql, null, page);
		page1.setList(list);
		return page1;
	}
	
	

}
