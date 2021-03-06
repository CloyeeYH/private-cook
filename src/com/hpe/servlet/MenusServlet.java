package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.Menus;
import com.hpe.pojo.Types;
import com.hpe.service.IMenusService;
import com.hpe.service.ITypesService;
import com.hpe.service.impl.MenusServiceImpl;
import com.hpe.service.impl.TypesServiceImpl;
import com.hpe.util.Page;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;


@WebServlet("/menusServlet")
public class MenusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IMenusService menusService = new MenusServiceImpl();
    private ITypesService typesService = new TypesServiceImpl();
    public MenusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("all")){
			MenusPage(request, response);
		}else if(action.equals("add")){
			addMenus(request, response);
		}else if(action.equals("findTypeAll")){
			findTypeAll(request, response);
		}else if(action.equals("update")){
			update(request, response);
		}
		
	}

	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Menus menu=new Menus();
		int id=Integer.parseInt(request.getParameter("id"));
		menu.setName(request.getParameter("name"));
		menu.setBurden(request.getParameter("burden"));
		menu.setPrice(request.getParameter("price"));
		menu.setPrice1(request.getParameter("price1"));
		menu.setBrief(request.getParameter("brief"));
		menu.setTypeid(request.getParameter("typeid"));	
		menu.setId(id);
		int result=menusService.updateMenus(menu);
		if(result==1){
			out.write("<script>"
					+
					"alert('?????????????????????');"
					+"window.location.href='"+request.getContextPath()+"/menusServlet?action=all';"//?????????
					+"</script>");
		}else{
			out.write("<script>"
					+
					"alert('????????????');"
					+"window.location.href='"+request.getContextPath()+"/menusServlet?action=all';"//?????????
					+"</script>");//????????????????????????jsp???

		}
	}

	

	protected void findTypeAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Types> list = typesService.getTypesAll();
		request.setAttribute("types", list);
		request.getRequestDispatcher("/admin/menus_add.jsp").forward(request, response);
	}
	

	protected void MenusPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//??????????????????
		String curPage=request.getParameter("curPage");
		int curPageStr=0;
		//?????????????????????????????????????????????
		if(curPage==null||" ".equals(curPage)){
			curPageStr=1;
		}else{
			curPageStr=Integer.parseInt(curPage);
		}
		//??????page
		Page page = new Page();
		page.setCurPage(curPageStr);
		page.setPageNumber(3);
		//??????????????????
		page= menusService.getMenus(page);
		//??????request??????????????????????????????
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/menus.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	protected void addMenus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		//??????SmartUpload???????????????
		SmartUpload smartUpload = new SmartUpload();
		//????????????????????????
		smartUpload.initialize(this.getServletConfig(), request, response);
		try {
			//??????????????????
			smartUpload.upload();
			String name = smartUpload.getRequest().getParameter("name");
			String burden = smartUpload.getRequest().getParameter("burden");
			String price = smartUpload.getRequest().getParameter("price");
			String price1 = smartUpload.getRequest().getParameter("price1");
			String brief = smartUpload.getRequest().getParameter("brief");
			String typeid = smartUpload.getRequest().getParameter("typeid");
			SmartFile file = smartUpload.getFiles().getFile(0);
			String imgPath = "img/" + file.getFileName();
			Menus menus = new Menus(name, typeid, burden, brief, price, price1, imgPath);
			int result = menusService.updateMenus(menus);
			if (result == 1) {
				//??????????????????????????????
				smartUpload.save("/img");
				out.write("<script>" + "alert('????????????');" + "window.parent.location.href='" + request.getContextPath()
						+ "/menusServlet?action=all';" + "</script>");
			} else if (result == -1) {
				out.write("<script>" + "alert('???????????????');" + "window.location.href='" + request.getContextPath()
						+ "/menusServlet?action=findTypeAll';" + "</script>");
			} else {
				out.write("<script>" + "alert('????????????');" + "window.location.href='" + request.getContextPath()
						+ "/menusServlet?action=findTypeAll';" + "</script>");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}		
	}

}
