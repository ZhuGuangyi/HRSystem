package com.leon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leon.entity.Employee;
import com.leon.service.IEmployeeService;
import com.leon.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class SelectEmployeeAction
 */
@WebServlet("/selectEmployee.action")
public class SelectEmployeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectEmployeeAction() {
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
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String duty = request.getParameter("duty");
		String currentPage1 = request.getParameter("currentPage1");
		
		IEmployeeService iEmployeeService=new EmployeeServiceImpl();
		Employee e=new Employee(name,department,duty);
		
		if(currentPage1 != null){
			e=(Employee)request.getSession().getAttribute("e");
		}
		request.getSession().setAttribute("e", e);
		List<Object> obj=iEmployeeService.selectEmployee(e, currentPage1);
		
		request.setAttribute("lists", obj.get(0));
		request.setAttribute("currentPage", obj.get(1));
		request.setAttribute("pageCount", obj.get(2));
		request.setAttribute("name", name);
		request.setAttribute("department", department);
		request.setAttribute("duty", duty);
		
		request.getRequestDispatcher("WEB-INF/InformationOverview.jsp").forward(request, response);
	}

}
