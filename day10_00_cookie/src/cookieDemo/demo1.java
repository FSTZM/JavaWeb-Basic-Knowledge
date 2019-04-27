package cookieDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取客户端保存的最后访问时间
		
		//编码 -- 要在客户端显示
		//request.setCharacterEncoding（）：是设置从request中取得的值或从数据库中取出的值.
		//response.setContentType指定 返回给客户端的编码,同时指定了浏览器显示的编码.
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if("lastAccessTime".equals(cookies[i].getName())){//判断当前Cookie中的name是否是想要的cookie
				long l = Long.parseLong(cookies[i].getValue());//如果是想要的Cookie，则把Cookie中的value取出
				out.write("你的最后访问时间为："+new Date(l).toLocaleString());
			}
		}
		
		
		//创建cookie,并把信息写回到客户端（浏览器）
		Cookie ck = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		//设置cookie的有效时间,单位是秒
		ck.setMaxAge(60);
		//设置cookie的path
		//ck.setPath("/day10_00_cookie");
		//ck.setPath(request.getContextPath());//  /day10_00_cookie
		ck.setPath("/");//  /day10_00_cookie
		//把cookie信息写回到客户端
		response.addCookie(ck);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
