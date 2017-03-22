package com.leon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BackAction
 */
@WebServlet("/back.action")
public class BackAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackAction() {
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
		HttpSession session = request.getSession();
		// 强制让session失效
		session.invalidate();
		// 读取浏览器存储的cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			for (Cookie c : cookies)
			{
				String name = c.getName(); // 获取cookie的name值
				if (name.equals("name"))
				{
					c.setMaxAge(0);     //让cookie失效
					response.addCookie(c);    //重新将cookie添加到响应头信息中
				}
			}
		}
		response.sendRedirect("HRlogin.jsp");
	}
}
