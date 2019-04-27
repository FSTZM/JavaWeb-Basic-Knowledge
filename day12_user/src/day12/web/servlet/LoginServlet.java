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
		
		
		
		//��form�����Զ���װ��User����
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
		
		//����ҵ���߼� -- login
		UserService us = new UserServiceImpl();
		User u;
		try {
			u = us.login(user);
		
			//�ַ�ת�� -- Ҫ��֤ȡ��name,ͬʱ�ж�u�Ƿ�Ϊ��
			if(u!=null){
				//��½�ɹ�������user����ŵ�session��
				request.getSession().setAttribute("user", u);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
			}
			
		} catch (UsersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//�����쳣��Ϣ --- ��������Ϣ���ص���ҳ��
			request.setAttribute("msg", e.getMessage());
			//��¼ʧ�ܣ��������µ�½
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
