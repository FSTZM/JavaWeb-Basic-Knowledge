package ResponseDemo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*		//���߷�����ʹ��UTF-8����
		response.setCharacterEncoding("UTF-8");
		//�������������ʲô����
		response.setHeader("content-type", "text/html;charset=UTF-8");*/
		
		
		
		//��һ�仰д���뷽ʽ
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write("�׺�");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
