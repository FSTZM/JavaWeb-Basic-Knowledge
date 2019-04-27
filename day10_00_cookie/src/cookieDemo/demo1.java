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

		//��ȡ�ͻ��˱����������ʱ��
		
		//���� -- Ҫ�ڿͻ�����ʾ
		//request.setCharacterEncoding�����������ô�request��ȡ�õ�ֵ������ݿ���ȡ����ֵ.
		//response.setContentTypeָ�� ���ظ��ͻ��˵ı���,ͬʱָ�����������ʾ�ı���.
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if("lastAccessTime".equals(cookies[i].getName())){//�жϵ�ǰCookie�е�name�Ƿ�����Ҫ��cookie
				long l = Long.parseLong(cookies[i].getValue());//�������Ҫ��Cookie�����Cookie�е�valueȡ��
				out.write("���������ʱ��Ϊ��"+new Date(l).toLocaleString());
			}
		}
		
		
		//����cookie,������Ϣд�ص��ͻ��ˣ��������
		Cookie ck = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		//����cookie����Чʱ��,��λ����
		ck.setMaxAge(60);
		//����cookie��path
		//ck.setPath("/day10_00_cookie");
		//ck.setPath(request.getContextPath());//  /day10_00_cookie
		ck.setPath("/");//  /day10_00_cookie
		//��cookie��Ϣд�ص��ͻ���
		response.addCookie(ck);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
