package com.hpe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.service.IMenusService;
import com.hpe.service.impl.MenusServiceImpl;
import com.hpe.util.Page;


@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private IMenusService menusService = new MenusServiceImpl();
	
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取当前页码
		String curPage=request.getParameter("pageIndex");
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
		page.setPageNumber(6);
		//调用查询方法
		page= menusService.getMenus(page);
		//放到request域中，转发给前台页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/qiantai/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
