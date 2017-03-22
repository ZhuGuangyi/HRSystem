package com.leon.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leon.service.IEmployeeService;
import com.leon.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class AjaxAction
 */
@WebServlet("/ajax.action")
public class AjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAction() {
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
		String flag = request.getParameter("flag");
		IEmployeeService iEmployeeService = new EmployeeServiceImpl();
		PrintWriter writer = response.getWriter();
		if("checkId".equals(flag)){
			int id = Integer.parseInt(request.getParameter("id"));
			if(iEmployeeService.checkID(id)){
				writer.print("<font color='red'>ID已注册，请使用另外的ID</font>");
			}else{
				writer.print("<font color='green'>ID可以使用</font>");
				
			}
		}
	}

}
