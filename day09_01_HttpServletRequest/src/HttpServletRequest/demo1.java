package HttpServletRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * getMethod() �������ʽ
		 * ***getReaquestURL() �����������е���Դ����
		 * ***getRequestURI() �����������е���Դ������
		 * *****getContextPath() ��ǰӦ�õ�����Ŀ¼
		 * getQueryString() �����������еĲ�������
		 */
		
		System.out.println(request.getMethod());
		System.out.println(request.getRequestURL());
		System.out.println(request.getRequestURI());
		System.out.println(request.getContextPath());
		System.out.println(request.getQueryString());
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
