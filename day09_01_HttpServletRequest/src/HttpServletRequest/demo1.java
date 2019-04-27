package HttpServletRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * getMethod() 获得请求方式
		 * ***getReaquestURL() 返回请求行中的资源部分
		 * ***getRequestURI() 返回请求行中的资源名部分
		 * *****getContextPath() 当前应用的虚拟目录
		 * getQueryString() 返回请求行中的参数部分
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
