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

import com.hpe.pojo.Types;
import com.hpe.service.IAdminService;
import com.hpe.service.ITypesService;
import com.hpe.service.impl.AdminServiceImpl;
import com.hpe.service.impl.TypesServiceImpl;


@WebServlet("/typesServlet")
public class TypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITypesService typesService = new TypesServiceImpl();
    
    public TypesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("findAll")){
			findAll(request, response);
		}else if(action.equals("add")){
			addTypes(request, response);
		}else if(action.equals("update")){
			update(request, response);
		}else if (action.equals("findTypeById")){
			findTypeById(request, response);
		}else if(action.equals("delete")){
			deleteTypes(request, response);
		}else{}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有类被
		List<Types> types = typesService.getTypesAll();
		//查询结果放到request域
		request.setAttribute("types", types);
		//转发给jsp页面
		request.getRequestDispatcher("/admin/type.jsp").forward(request, response);
		
	}
	protected void addTypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		Types type = new Types();
		type.setName(name);
		int result = typesService.addTypes(type);
		if(result==1){
			out.write("<script>"
					+"alert('添加成功');"
					+"window.location.href='"+request.getContextPath()+"/typesServlet?action=findAll';"
					+"</script>");
		}else if(result==-1){
			out.write("<script>"
					+"alert('类别名重复');"
					+"window.location.href='"+request.getContextPath()+"/admin/type_add.jsp';"
					+"</script>");
		}else{
			out.write("<script>"
					+"alert('添加失败');"
					+"window.location.href='"+request.getContextPath()+"/admin/type_add.jsp';"
					+"</script>");
		}
		
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		String name =request.getParameter("name");
		Types types = new Types();
		types.setId(id);
		types.setName(name);
		int result = typesService.updateTypes(types);
		if(result==1){
			out.write("<script>"
					+"alert('修改成功');"
					+"window.location.href='"+request.getContextPath()+"/typesServlet?action=findAll';"
					+"</script>");
		}else if(result==-1){
			out.write("<script>"
					+"alert('类别名重复');"
					+"window.location.href='"+request.getContextPath()+"/typesServlet?action=findTypeById&&id="+types.getId()+"';"
					+"</script>");
		}else{
			out.write("<script>"
					+"alert('修改失败');"
					+"window.location.href='"+request.getContextPath()+"/admin/type_update.jsp';"
					+"</script>");
		}
		
		
	}
	protected void findTypeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		Types type = typesService.getTypesById(id);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/admin/type_update.jsp").forward(request, response);
		
		
	}
	protected void deleteTypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		int result = typesService.deleteTypes(id);
		if(result==1){
			out.write("<script>"
					+"alert('删除成功');"
					+"window.location.href='"+request.getContextPath()+"/typesServlet?action=findAll';"
					+"</script>");
		}else if(result==-1){
			out.write("<script>"
					+"alert('类别名重复');"
					+"window.location.href='"+request.getContextPath()+"/admin/type.jsp';"
					+"</script>");
		}else{
			out.write("<script>"
					+"alert('删除失败');"
					+"window.location.href='"+request.getContextPath()+"/admin/type.jsp';"
					+"</script>");
		}
	}

}
