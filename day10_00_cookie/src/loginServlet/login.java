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
		
		//�õ��ͻ��˱����cookie����
		Cookie[] cookies = request.getCookies();
		//�ж�userName�Ƿ��cookie�е�һ�£����һ��˵�����������
		//�����һ�£�Ϊ�գ�˵������û�б����
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if("userName".equals(cookies[i].getName())){
				userName = cookies[i].getValue();
				checked = "checked='checked'";
			}
		}
		
		out.write("<form action='"+request.getContextPath()+"/servlet/doLogin' method='post'>");
		out.write("�û�����<input type='text' name='userName' value='"+userName+"'></br>");
		out.write("���룺<input type='password' name='pwd'userName'></br>");
		out.write("��ס�û�����<input type='checkbox' name='remember' "+checked+" '></br>");
		out.write("��¼��<input type='submit' value='��¼'></br>");
		out.write("</form>");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
