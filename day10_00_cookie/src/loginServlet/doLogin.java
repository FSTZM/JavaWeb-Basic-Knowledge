package loginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class doLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//获取表单数据
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String remenber = request.getParameter("remember");

		Cookie ck = new Cookie("userName",userName);
		ck.setPath("/");
		//处理业务逻辑
		//分发转向
		if("tom".equals(userName) && "123".equals(pwd)){//判断用户名密码是都一致
			//如果一致，则登陆成功并记住用户名
			//先判断之前是否记住过用户名，如果记住过，返回cookie
			//如果没有，删除cookie
			if(remenber!=null){
				ck.setMaxAge(Integer.MAX_VALUE);
			}else{
				ck.setMaxAge(0);
			}
			
			//将cookie写回到客户端
			response.addCookie(ck);
			
			out.write("登陆成功！");
		}else{
			//否则登录失败，跳转
			out.write("登录失败！");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"servlet/login");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
