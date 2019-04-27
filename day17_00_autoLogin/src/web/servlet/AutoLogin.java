package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

public class AutoLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService us = new UserService();
		User u = us.findUser(username,password);
		
		if(u!=null){
			//如果勾选了复选框，就把信息保存到cookie中
			String checkbox = request.getParameter("checkbox");
			Cookie ck = new Cookie("user", u.getUsername()+"&"+u.getPassword());//Constructs a cookie with a specified name and value.
			if(checkbox!=null){//如果是，就要保存信息到cookie中				
				ck.setPath("/");
				ck.setMaxAge(60*60*24*7);		
			}else{//如果不是，要清除cookie信息
				ck.setMaxAge(0);
			}
			response.addCookie(ck);
			
			request.getSession().setAttribute("user", u);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("msg", "账号或密码错误！");
			request.getRequestDispatcher("/autoLogin.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
