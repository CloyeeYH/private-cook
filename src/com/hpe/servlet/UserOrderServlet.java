package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.pojo.ShoppingCart;
import com.hpe.pojo.Users;
import com.hpe.service.IOrderService;
import com.hpe.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class UserOrderServlet
 */
@WebServlet("/userOrderServlet")
public class UserOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IOrderService orderService = new OrderServiceImpl();  
   
    public UserOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("addOrder")){
			addOrder(request, response);
		}
	}

	protected void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		//获取用户信息
		Users user= (Users)session.getAttribute("user");
		//获取购物车
		List<ShoppingCart> list = (List<ShoppingCart>) session.getAttribute("shoppingCart");
		if(user!=null){
			boolean res;
			try {
				res = orderService.addOrder(user.getId(), list);
				if(res){
					//清空购物车
					session.removeAttribute("shoppingCart");
					out.write("<script>"
							+"alert('订单提交成功');"
							+"window.location.href='"+request.getContextPath()+"/qiantai/order.jsp';"
							+"</script>");
				}else{
					out.write("<script>"
							+"alert('订单提交失败');"
							+"window.location.href='"+request.getContextPath()+"/qiantai/shoppingcar.jsp';"
							+"</script>");
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}else{
			out.write("<script>"
					+"alert('请登陆后再提交订单');"
					+"window.parent.location.href='"+request.getContextPath()+"/qiantai/login.jsp';"
					+"</script>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
