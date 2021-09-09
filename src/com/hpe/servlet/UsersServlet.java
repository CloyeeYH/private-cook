package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.pojo.Admin;
import com.hpe.pojo.Users;
import com.hpe.service.IUsersService;
import com.hpe.service.impl.UsersServiceImpl;


@WebServlet("/usersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUsersService usersService = new UsersServiceImpl();
    
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
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
		}else if(action.equals("update")){
			update(request, response);
		}else if(action.equals("logout")){
			logout(request, response);
		}else if(action.equals("registe")){
			registe(request, response);
		}
	}

	protected void registe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex=request.getParameter("sex");
		String realname=request.getParameter("realname");
		String age = request.getParameter("age");
		String card= request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		Users user = new Users();
		user.setName(name);
		user.setPwd(pwd);
		user.setRealname(realname);
		user.setAge(age);
		user.setSex(sex);
		user.setCard(card);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setCode(code);
		int result = usersService.registe(user);
		if(result==1){
			session.removeAttribute("user");
			out.write("<script>"
					+"alert('注册成功');"
					+"window.parent.location.href='"+request.getContextPath()+"/qiantai/login.jsp';"
					+"</script>");
		}else if(result==-1){
			out.write("<script>"
					+"alert('用户名重复');"
					+"window.location.href='"+request.getContextPath()+"/qiantai/center.jsp';"
					+"</script>");
		}else{
			out.write("<script>"
					+"alert('注册失败');"
					+"window.location.href='"+request.getContextPath()+"/qiantai/center.jsp';"
					+"</script>");
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");

		String pwd= request.getParameter("pwd");
	
		Users user=usersService.login(name, pwd);
		
		if(user!=null){
			session.setAttribute("user", user);
			out.write("<script>"
					+"alert('恭喜你登陆成功');"
					+"window.location.href='"+request.getContextPath()+"/qiantai/index.jsp';"
					+"</script>");
			
		}else{out.write("<script>"
				+"alert('登陆失败');"
				+"window.location.href='"+request.getContextPath()+"/qiantai/login.jsp';"
				+"</script>");
			
		}
		
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清除session，跳转登录页
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		out.write("<script>"
				+"alert('退出成功');"
				+"window.parent.location.href='"+request.getContextPath()+"/qiantai/index.jsp';"
				+"</script>");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		HttpSession session = request.getSession();
		String pwd = request.getParameter("pwd");
		String realname=request.getParameter("realname");
		String age = request.getParameter("age");
		String card= request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("eamil");
		String code = request.getParameter("code");
		int id= Integer.parseInt((request.getParameter("id")));
		Users user = new Users();
		user.setPwd(pwd);
		user.setRealname(realname);
		user.setAge(age);
		user.setCard(card);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setCode(code);
		user.setId(id);
		int result = usersService.updateUsers(user);
		if(result==1){
			session.removeAttribute("user");
			out.write("<script>"
					+"alert('修改成功');"
					+"window.parent.location.href='"+request.getContextPath()+"/qiantai/login.jsp';"
					+"</script>");
		}else if(result==-1){
			out.write("<script>"
					+"alert('用户名重复');"
					+"window.location.href='"+request.getContextPath()+"/qiantai/center.jsp';"
					+"</script>");
		}else{
			out.write("<script>"
					+"alert('修改失败');"
					+"window.location.href='"+request.getContextPath()+"/qiantai/center.jsp';"
					+"</script>");
		}
	}

}
