/**
 * 
 */
package com.hpe.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import com.hpe.dao.IOrderDao;
import com.hpe.dao.impl.OrderDaoImpl;
import com.hpe.pojo.Order;
import com.hpe.pojo.Orders;
import com.hpe.pojo.OrdersInfo;
import com.hpe.pojo.ShoppingCart;
import com.hpe.service.IOrderService;
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

public class OrderServiceImpl implements IOrderService {

	private IOrderDao orderDao = new OrderDaoImpl();
	@Override
	public boolean addOrder(int userId, List<ShoppingCart> list) throws Exception {
		boolean flag = false;
		try {
			//开启事务
			DBUtil.beginTranscation();
			//遍历添加
			for (ShoppingCart cart : list) {
				Order order = new Order();
				order.setUserid(userId);
				order.setMenuid(cart.getMenuid());
				order.setMenusum(String.valueOf(cart.getSum()));
				order.setDelivery("0");//默认为未派送
				order.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				orderDao.addOrder(order);
			}
			//提交事务
			DBUtil.endTranscation();
			flag = true;
		} catch (Exception e) {
			try {
				//回滚
				DBUtil.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			
		}finally{
			DBUtil.closeConn();
		}
		return flag;
	}
	
	@Override
	public Page getOrderSearch(Page page, OrdersInfo ordersInfo) {
		
		return orderDao.getOrderSearch(page, ordersInfo);
	}


	
	@Override
	public int ensure(int id) {
		
		return orderDao.ensure(id);
	}


	@Override
	public List<Orders> statistic() {
		return orderDao.statistic();
	}

	
	@Override
	public Page getOrders(Page page) {
		
		return orderDao.getOrders(page);
	}

}
