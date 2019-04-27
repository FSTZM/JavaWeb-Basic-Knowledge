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
		
		//��ȡ������
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String remenber = request.getParameter("remember");

		Cookie ck = new Cookie("userName",userName);
		ck.setPath("/");
		//����ҵ���߼�
		//�ַ�ת��
		if("tom".equals(userName) && "123".equals(pwd)){//�ж��û��������Ƕ�һ��
			//���һ�£����½�ɹ�����ס�û���
			//���ж�֮ǰ�Ƿ��ס���û����������ס��������cookie
			//���û�У�ɾ��cookie
			if(remenber!=null){
				ck.setMaxAge(Integer.MAX_VALUE);
			}else{
				ck.setMaxAge(0);
			}
			
			//��cookieд�ص��ͻ���
			response.addCookie(ck);
			
			out.write("��½�ɹ���");
		}else{
			//�����¼ʧ�ܣ���ת
			out.write("��¼ʧ�ܣ�");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"servlet/login");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
