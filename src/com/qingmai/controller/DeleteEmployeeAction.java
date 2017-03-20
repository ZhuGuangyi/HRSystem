package com.qingmai.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qingmai.service.IEmployeeService;
import com.qingmai.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class DeleteEmployeeAction
 */
@WebServlet("/deleteEmployee.action")
public class DeleteEmployeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeAction() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		
		IEmployeeService iEmployeeService=new EmployeeServiceImpl();
		boolean flag=iEmployeeService.deleteEmployee(id);
		
		request.getRequestDispatcher("WEB-INF/InformationOverview.jsp").forward(request, response);
	}

}
