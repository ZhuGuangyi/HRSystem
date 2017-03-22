package com.leon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leon.entity.Employee;
import com.leon.service.IEmployeeService;
import com.leon.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class InformationEntryAction
 */
@WebServlet("/informationEntry.action")
public class InformationEntryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationEntryAction() {
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
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
//		String sex = request.getParameter("sex");
//		String degree = request.getParameter("degree");
//		String department = request.getParameter("department");
//		String duty = request.getParameter("duty");
//		String state = request.getParameter("state");
//		String introduction =request.getParameter("introduction");
		
//		Employee employee=new Employee();
//		employee.setId(id);
//		employee.setName(name);
//		employee.setAge(age);
//		employee.setSex(sex);
//		employee.setDegree(degree);
//		employee.setDepartment(department);
//		employee.setDuty(duty);
//		employee.setState(state);
//		employee.setIntroduction(introduction);
		IEmployeeService iEmployeeService=new EmployeeServiceImpl();
		if(iEmployeeService.insert(request)){
			request.setAttribute("success", "保存成功！");
			request.getRequestDispatcher("WEB-INF/InformationEntry.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("InformationOverview.jsp").forward(request,response);

		}
		
	}

}
