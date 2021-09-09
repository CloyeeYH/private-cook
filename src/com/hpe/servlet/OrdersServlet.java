package com.hpe.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;

import com.hpe.pojo.Orders;
import com.hpe.pojo.OrdersInfo;
import com.hpe.pojo.ShoppingCart;
import com.hpe.pojo.Types;
import com.hpe.service.IOrderService;
import com.hpe.service.impl.OrderServiceImpl;
import com.hpe.util.DBUtil;
import com.hpe.util.Page;

/**
 * 后台的订单servlet
 */
@WebServlet("/ordersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IOrderService orderService = new OrderServiceImpl();  
    private DBUtil dbutil = new DBUtil();
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("search")){
			search(request, response);
		}else if(action.equals("findAll")){
			findAll(request, response);
		}else if (action.equals("ensure")){
			ensure(request, response);
		}else if(action.equals("delete")){
			delete(request, response);
		}else if (action.equals("statistic")){
			statistic(request, response);
		}
		
	}
	
	
	protected void statistic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Orders> orders = orderService.statistic();
		
		request.setAttribute("order",orders);
		
		request.getRequestDispatcher("/admin/order_statistic.jsp").forward(request, response);
		
		
	}
	protected void ensure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		orderService.ensure(id);
	}

	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session  = request.getSession();
		List<Orders> list =(List<Orders>) session.getAttribute("shoppingCart");
		for(Orders order:list){
			if(order.getId()==id){
				list.remove(order);
				break;
			}
		}
		String curPage = request.getParameter("pageIndex");
		session.setAttribute("Orders", list);
		response.sendRedirect(request.getContextPath()+"/IndexServlet?pageIndex="+curPage);	
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前页码
				String curPage=request.getParameter("curPage");
				int curPageStr=0;
				//如果当前页码为空，设置为第一页
				if(curPage==null||" ".equals(curPage)){
					curPageStr=1;
				}else{
					curPageStr=Integer.parseInt(curPage);
				}
				//创建page
				Page page = new Page();
				page.setCurPage(curPageStr);
				page.setPageNumber(3);
				//调用查询方法
				page= orderService.getOrders(page);
				//放到request域中，转发给前台页面
				request.setAttribute("page", page);
				request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
		
				
	}

	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String menuname  =request.getParameter("menuname");
		String date = request.getParameter("date");
		String curPage =request.getParameter("curPage");
		int curPageStr=0;
		if(curPage==null||curPage.equals(" ")){
			curPageStr=1;
		}else{
			curPageStr=Integer.parseInt(curPage);
		}
		if(userid==null||userid==""){
			userid="0";
		}
		//传入页码
		Page page = new Page();
		page.setCurPage(curPageStr);
		//传入搜索条件
		OrdersInfo  ordersInfo = new OrdersInfo();
		ordersInfo.setUserid(Integer.parseInt(userid));
		ordersInfo.setDate(date);
		ordersInfo.setMenuname(menuname);
		ordersInfo.setDelivery(-1);
		//调用方法
		page = orderService.getOrderSearch(page, ordersInfo);
		request.setAttribute("page", page);
		request.setAttribute("ordersInfo", ordersInfo);
		request.getRequestDispatcher("/admin/order_search.jsp").forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
