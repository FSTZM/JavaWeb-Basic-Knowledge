package ResponseDemo1;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*		//自动刷新
		response.setIntHeader("refresh", 1);
		Random r = new Random();
		response.getWriter().write(r.nextInt(10)+"");
*/		
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("注册成功!3秒钟跳到主页");
		response.setHeader("refresh", "3;url=/day09_00_HttpServletResponse/servlet/demo4");
		
		//重定向
		response.sendRedirect("/day09_00_HttpServletResponse/servlet/demo4");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
