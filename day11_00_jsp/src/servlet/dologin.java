package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dologin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��ȡ������
    	String userName = request.getParameter("userName");
    	String pwd = request.getParameter("pwd");
    	
    	//����ҵ���߼�
    	//�ַ�ת��
    	if("tom".equals(userName) && "123".equals(pwd)){
    		//request.setAttribute("name", userName);
    		request.getRequestDispatcher("/success.jsp").forward(request, response);
    	}else{
    		request.setAttribute("msg", "�û����������벻��ȷ��");
    		request.getRequestDispatcher("/login.jsp").forward(request, response);
    	}
	
    	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
