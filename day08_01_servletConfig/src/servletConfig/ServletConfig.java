package servletConfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfig extends HttpServlet {

//	private javax.servlet.ServletConfig config;
	
//	@Override
//	public void init(javax.servlet.ServletConfig config) throws ServletException {
//		this.config = config;
//	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//第一种方式
//		String encoding = config.getInitParameter("encoding");
//		System.out.println(encoding);

		//第二种方式
		String encoding = this.getServletConfig().getInitParameter("encoding");
		System.out.println(encoding);
		
		//第三种方式
//		String encoding = super.getInitParameter("encoding");
//		System.out.println(encoding);
		
		
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
