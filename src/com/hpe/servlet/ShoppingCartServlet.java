package com.hpe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.pojo.Menus;
import com.hpe.pojo.ShoppingCart;
import com.hpe.service.IMenusService;
import com.hpe.service.impl.MenusServiceImpl;


@WebServlet("/shoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IMenusService menusService = new MenusServiceImpl();
    
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;cahrset=utf-8");
		String action =request.getParameter("action");
		if(action.equals("add")){
			addCart(request, response);
		}else if(action.equals("delAll")){
			delAll(request, response);
		}else if (action.equals("delete")){
			delete(request, response);
		}else if(action.equals("delete1")){
			delete1(request, response);
		}else if(action.equals("delAll1")){
			delAll1(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int menuid = Integer.parseInt(request.getParameter("menuid"));
		HttpSession session  = request.getSession();
		List<ShoppingCart> cartList =(List<ShoppingCart>) session.getAttribute("shoppingCart");
		for(ShoppingCart cart:cartList){
			if(cart.getMenuid()==menuid){
				cartList.remove(cart);
				break;
			}
		}
		String curPage = request.getParameter("pageIndex");
		session.setAttribute("shoppingCart", cartList);
		response.sendRedirect(request.getContextPath()+"/IndexServlet?pageIndex="+curPage);	
	}
	protected void delete1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int menuid = Integer.parseInt(request.getParameter("menuid"));
		HttpSession session  = request.getSession();
		List<ShoppingCart> cartList =(List<ShoppingCart>) session.getAttribute("shoppingCart");
		for(ShoppingCart cart:cartList){
			if(cart.getMenuid()==menuid){
				cartList.remove(cart);
				break;
			}
		}
		String curPage = request.getParameter("pageIndex");
		session.setAttribute("shoppingCart", cartList);
		response.sendRedirect(request.getContextPath()+"/qiantai/shoppingcar.jsp");	
	}
	
	protected void delAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//???????????????
		HttpSession session  = request.getSession();
		//???????????????
		session.removeAttribute("shoppingCart");
		response.sendRedirect(request.getContextPath()+"/qiantai/index.jsp");
	}
	
	protected void delAll1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//???????????????
		HttpSession session  = request.getSession();
		//???????????????
		session.removeAttribute("shoppingCart");
		response.sendRedirect(request.getContextPath()+"/qiantai/shoppingcar.jsp");	
	}
	protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//????????????id
		int menuid = Integer.parseInt(request.getParameter("menuid"));
		int curPage = Integer.parseInt(request.getParameter("pageIndex"));
		//???????????????
		HttpSession session  = request.getSession();
		List<ShoppingCart> cartList =(List<ShoppingCart>) session.getAttribute("shoppingCart");
		//???????????????????????????
		boolean flag = false;
		//???????????????????????????
		if(cartList==null){
			//???????????????
			cartList = new ArrayList<ShoppingCart>();
		}else{
			//???????????????,????????????????????????????????????????????????1
			for(ShoppingCart cart:cartList){
				if(cart.getMenuid()==menuid){
					cart.setSum(cart.getSum()+1);
					flag=true;
					break;
				}
			}	
		}
		if(!flag){
			//?????????????????????
			ShoppingCart cart = new ShoppingCart();
			//??????id??????
			Menus menus = menusService.getMenusById(menuid);
			cart.setMenuid(menuid);
			cart.setName(menus.getName());
			cart.setSum(1);
			cart.setPrice(Float.parseFloat(menus.getPrice()));
			//????????????????????????list???
			cartList.add(cart);
			
			
		}
		//?????????????????????session??????
		session.setAttribute("shoppingCart", cartList);
		response.sendRedirect(request.getContextPath()+"/IndexServlet?pageIndex="+curPage);
		
		
	}

}
