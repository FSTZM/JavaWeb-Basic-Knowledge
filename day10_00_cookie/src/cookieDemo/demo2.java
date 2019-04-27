package cookieDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//����
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//��ȡ�ͻ���cookie
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies != null && i < cookies.length; i++) {
			String name = cookies[i].getName();
			if("lastAccessTime".equals(name)){
				long l = Long.parseLong(cookies[i].getValue());
				out.write("�����ʵ�ʱ���ǣ�" + new Date(l).toLocaleString());
			}
		}
		
		out.println();
		
		out.print("<a href='"+request.getContextPath()+"/servlet/clear'>clear</a>");
		
		//����cookie ��cookieд�뵽�ͻ���
		Cookie ck = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		
		ck.setPath("/");
		
		ck.setMaxAge(60*2);
		
		response.addCookie(ck);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
