package ResponseDemo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*		//告诉服务器使用UTF-8解码
		response.setCharacterEncoding("UTF-8");
		//告诉浏览器是用什么解码
		response.setHeader("content-type", "text/html;charset=UTF-8");*/
		
		
		
		//第一句话写编码方式
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write("雷猴");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
