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
 * Servlet implementation class ForwardAction
 */
@WebServlet("/forward.action")
public class ForwardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardAction() {
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
		String flag=request.getParameter("flag");
		if(flag.equals("InfoEntry")){
			request.getRequestDispatcher("WEB-INF/InformationEntry.jsp").forward(request, response);
		}
		if(flag.equals("InfoOverview")){
			request.getRequestDispatcher("WEB-INF/InformationOverview.jsp").forward(request, response);
		}
		if(flag.equals("updateEmployee")){
			System.out.println("flag.equals(updateEmployee)");
			int id=Integer.parseInt(request.getParameter("id"));
			
			IEmployeeService iEmployeeService = new EmployeeServiceImpl();
			Employee e = iEmployeeService.selectEmployee(id);
			System.out.println("aaa");
			request.setAttribute("e", e);
			System.out.println("aaa");
			System.out.println("e:"+e);
			request.getRequestDispatcher("WEB-INF/InformationUpdate.jsp").forward(request, response);
		}
	}

}
