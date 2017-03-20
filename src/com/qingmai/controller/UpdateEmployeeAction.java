package com.qingmai.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qingmai.entity.Employee;
import com.qingmai.service.IEmployeeService;
import com.qingmai.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class UpdateEmployeeAction
 */
@WebServlet("/updateEmployee.action")
public class UpdateEmployeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeAction() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String degree = request.getParameter("degree");
		String department = request.getParameter("department");
		String duty = request.getParameter("duty");
		
		IEmployeeService iEmployeeService = new EmployeeServiceImpl();
		Employee e = new Employee(id,name,age,degree,department,duty);
		boolean flag = iEmployeeService.updateEmployee(e);
		
		if(flag){
			request.getRequestDispatcher("WEB-INF/InformationOverview.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("forward.action?flag=updateEmployee&id="+id).forward(request, response);
		}
	}

}
