package com.qingmai.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qingmai.entity.Admin;
import com.qingmai.service.IAdminService;
import com.qingmai.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class LoginCLAction
 */
@WebServlet("/loginCL.action")
public class LoginCLAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCLAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminname=request.getParameter("name");
		String password=request.getParameter("pass");
		HttpSession session=request.getSession();
		String incode=request.getParameter("code");
		String checkcode=(String)session.getAttribute("checkcode");
		if(adminname == null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		IAdminService iAdminService=new AdminServiceImpl();
		Admin a=new Admin(adminname,password);
		boolean flag=iAdminService.checkLogin(a);
		if(flag && incode.equalsIgnoreCase(checkcode)){
			session.setAttribute("name", adminname);
			request.getRequestDispatcher("WEB-INF/indexHR.jsp").forward(request, response);
		}else if(checkcode.equalsIgnoreCase(incode)!=true){
			request.setAttribute("err","验证码错误，请重新输入！");
			request.getRequestDispatcher("HRlogin.jsp").forward(request, response);
		}
		else{
			request.setAttribute("err","用户名或密码错误，请重新输入！");
			request.getRequestDispatcher("HRlogin.jsp").forward(request, response);
		}
		
	}

}
