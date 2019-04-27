package com.itheima.product.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.product.domain.User;

public class MyAccount extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request, response);

		} else {
			if ("admin".equals(user.getRole())) {
				request.getRequestDispatcher("/admin/login/home.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("/myAccount.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
