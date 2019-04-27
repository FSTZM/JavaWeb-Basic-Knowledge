package day12.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import day12.domain.User;
import day12.domain.UserForm;
import day12.exception.UserExistException;
import day12.service.UserService;
import day12.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		/*
		 * 登陆之前先进行验证
		 * 验证通过，则继续，验证不通过则return，不执行下面语句
		 */
		
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (!uf.validate()) {// 如果map中不为空，说明有错误信息
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		
		
///////////////////////////////////////////////////////////////////////////////////////////
		
		
		User user = new User();
		//获取表单数据
		try {
			//日期转换
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
			
			//调用业务逻辑（）注册
			UserService us = new UserServiceImpl();
			
			//查看用户名是否已被注册
			us.findUserByName(user.getUsername());
			us.register(user);
			
		} catch(UserExistException e1){
			request.setAttribute("error", "用户名已经存在！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//分发转向
		response.getWriter().print("注册成功！一秒钟后跳转到主页！");
		response.setHeader("refresh", "1;url='"+request.getContextPath()+"/index.jsp'");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
