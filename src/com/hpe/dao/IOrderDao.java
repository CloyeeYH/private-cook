/**
 * 
 */
package com.hpe.dao;

import java.util.List;

import com.hpe.pojo.Order;
import com.hpe.pojo.Orders;
import com.hpe.pojo.OrdersInfo;
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

public interface IOrderDao {

	/**
	 * 
	 * 方法描述：添加订单
	 * @param order
	 * @return 影响的行数
	 */
	int addOrder (Order order);
	
	/**
	 * 
	 * 方法描述：多条件查询
	 * @param page分页信息
	 * @param ordersInfo 查询条件
	 * @return 订单信息
	 */
	
	Page getOrderSearch(Page page,OrdersInfo ordersInfo);

	/**
	 * 
	 * 方法描述：分页查询
	 * @param page
	 * @return 分页后的数据
	 */
	Page getOrders(Page page);
	
	/**
	 * 
	 * 方法描述：确定
	 * @param id 
	 * @return 影响的行数
	 */
	public int ensure(int id);
	
	/**
	 * 
	 * 方法描述：本日销售统计
	 * @return
	 */
	List<Orders> statistic();
	
}
