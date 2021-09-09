package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.hpe.dao.IAdminDao;
import com.hpe.pojo.Admin;
import com.hpe.service.IAdminService;
import com.hpe.service.impl.AdminServiceImpl;


@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdminService adminService = new AdminServiceImpl();
	
    
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stubs
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求转码
		request.setCharacterEncoding("utf-8");
		//响应转码
		response.setContentType("text/html;charset=utf-8");
		//获取请求参数action
		String action=request.getParameter("action");
		//判断action的值决定调用什么方法
		if(action.equals("login")){
			login(request, response);
		}else if(action.equals("logout")){
			logout(request, response);
		}else if(action.equals("update")){
			update(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		//获取用户名
		String name = request.getParameter("name");
		//获取密码
		String pwd= request.getParameter("pwd");
		//调用service
		Admin admin=adminService.login(name, pwd);
		//admin不等于空登陆成功
		if(admin!=null){
			session.setAttribute("admin", admin);

			out.write("<script>"
					+"alert('恭喜你登陆成功');"
					+"window.location.href='"+request.getContextPath()+"/admin/main.jsp';"
					+"</script>");
			
		}else{out.write("<script>"
				+"alert('登陆失败');"
				+"window.location.href='"+request.getContextPath()+"/admin/index.jsp';"
				+"</script>");
			
		}
		
		
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清除session，跳转登录页
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		out.write("<script>"
				+"alert('退出成功');"
				+"window.parent.location.href='"+request.getContextPath()+"/admin/index.jsp';"
				+"</script>");
		
		
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		HttpSession session = request.getSession();
		String name =request.getParameter("name");
		String pwd = request.getParameter("pwd");
		int id= Integer.parseInt((request.getParameter("id")));
		Admin admin = new Admin();
		admin.setId(id);
		admin.setName(name);
		admin.setPwd(pwd);
		int result = adminService.updateAdmin(admin);
		if(result==1){
			session.removeAttribute("admin");
			out.write("<script>"
					+"alert('修改成功');"
					+"window.parent.location.href='"+request.getContextPath()+"/admin/index.jsp';"
					+"</script>");
		}else if(result==-1){
			out.write("<script>"
					+"alert('用户名重复');"
					+"window.location.href='"+request.getContextPath()+"/admin/admin_update.jsp';"
					+"</script>");
		}else{
			out.write("<script>"
					+"alert('修改失败');"
					+"window.location.href='"+request.getContextPath()+"/admin/admin_update.jsp';"
					+"</script>");
		}
		
		
	}
	
}
