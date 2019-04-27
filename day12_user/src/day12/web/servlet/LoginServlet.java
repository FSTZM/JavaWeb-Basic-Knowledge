package day12.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import day12.domain.User;
import day12.domain.UserForm;
import day12.exception.UsersException;
import day12.service.UserService;
import day12.service.impl.UserServiceImpl;
import day12.utils.DBUtils;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		//将form参数自动封装成User对象
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//调用业务逻辑 -- login
		UserService us = new UserServiceImpl();
		User u;
		try {
			u = us.login(user);
		
			//分发转向 -- 要保证取到name,同时判断u是否为空
			if(u!=null){
				//登陆成功，并把user对象放到session中
				request.getSession().setAttribute("user", u);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
			}
			
		} catch (UsersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//返回异常信息 --- 将错误信息返回到主页面
			request.setAttribute("msg", e.getMessage());
			//登录失败，返回重新登陆
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
