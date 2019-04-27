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
		 * ��½֮ǰ�Ƚ�����֤
		 * ��֤ͨ�������������֤��ͨ����return����ִ���������
		 */
		
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (!uf.validate()) {// ���map�в�Ϊ�գ�˵���д�����Ϣ
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		
		
///////////////////////////////////////////////////////////////////////////////////////////
		
		
		User user = new User();
		//��ȡ������
		try {
			//����ת��
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
			
			//����ҵ���߼�����ע��
			UserService us = new UserServiceImpl();
			
			//�鿴�û����Ƿ��ѱ�ע��
			us.findUserByName(user.getUsername());
			us.register(user);
			
		} catch(UserExistException e1){
			request.setAttribute("error", "�û����Ѿ����ڣ�");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ַ�ת��
		response.getWriter().print("ע��ɹ���һ���Ӻ���ת����ҳ��");
		response.setHeader("refresh", "1;url='"+request.getContextPath()+"/index.jsp'");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
