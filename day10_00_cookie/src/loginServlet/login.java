package loginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String userName="";
		String checked ="";
		
		//得到客户端保存的cookie数据
		Cookie[] cookies = request.getCookies();
		//判断userName是否和cookie中的一致，如果一致说明曾经保存过
		//如果不一致，为空，说明曾经没有保存过
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if("userName".equals(cookies[i].getName())){
				userName = cookies[i].getValue();
				checked = "checked='checked'";
			}
		}
		
		out.write("<form action='"+request.getContextPath()+"/servlet/doLogin' method='post'>");
		out.write("用户名：<input type='text' name='userName' value='"+userName+"'></br>");
		out.write("密码：<input type='password' name='pwd'userName'></br>");
		out.write("记住用户名：<input type='checkbox' name='remember' "+checked+" '></br>");
		out.write("登录：<input type='submit' value='登录'></br>");
		out.write("</form>");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
