package com.itheima.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendDataServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//请求方式
		String method = request.getMethod();
		System.out.println("1.请求方式:"+method);
		//请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("2.请求数据:"+username);
		System.out.println("3.请求数据:"+password);
		
		//响应数据
		String jsonData = "{\"message：\":\"成功\"}";
		
		//发送数据
		response.getWriter().print(jsonData);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
