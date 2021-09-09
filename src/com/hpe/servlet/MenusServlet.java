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
					"alert('恭喜你修改成功');"
					+"window.location.href='"+request.getContextPath()+"/menusServlet?action=all';"//项目名
					+"</script>");
		}else{
			out.write("<script>"
					+
					"alert('修改失败');"
					+"window.location.href='"+request.getContextPath()+"/menusServlet?action=all';"//项目名
					+"</script>");//拼接，脚本应写到jsp里

		}
	}

	

	protected void findTypeAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Types> list = typesService.getTypesAll();
		request.setAttribute("types", list);
		request.getRequestDispatcher("/admin/menus_add.jsp").forward(request, response);
	}
	

	protected void MenusPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		page= menusService.getMenus(page);
		//放到request域中，转发给前台页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/menus.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	protected void addMenus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		//创建SmartUpload初始化对象
		SmartUpload smartUpload = new SmartUpload();
		//执行上传的初始化
		smartUpload.initialize(this.getServletConfig(), request, response);
		try {
			//执行文件上传
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
				//修改完成之后执行保存
				smartUpload.save("/img");
				out.write("<script>" + "alert('修改成功');" + "window.parent.location.href='" + request.getContextPath()
						+ "/menusServlet?action=all';" + "</script>");
			} else if (result == -1) {
				out.write("<script>" + "alert('类别名重复');" + "window.location.href='" + request.getContextPath()
						+ "/menusServlet?action=findTypeAll';" + "</script>");
			} else {
				out.write("<script>" + "alert('修改失败');" + "window.location.href='" + request.getContextPath()
						+ "/menusServlet?action=findTypeAll';" + "</script>");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}		
	}

}
