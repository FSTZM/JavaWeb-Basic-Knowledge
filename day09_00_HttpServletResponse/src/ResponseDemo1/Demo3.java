package ResponseDemo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.�õ�·�� ����������
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/�ű�����.jpg");
		FileInputStream fis = new FileInputStream(path);

		
		//2.���������
		ServletOutputStream sos = response.getOutputStream();
		
		//�ļ���
		String filename =path.substring(path.lastIndexOf("\\")+1);//���������ļ��洢��·����D:\eclipse����"\"
																//���ʱд����/WEB-INF/classes/�ű�����.jpg "/"
		//�����ļ�����
		filename = URLEncoder.encode(filename,"UTF-8");
		
		//��֪�ͻ���Ҫ�����ļ�
		response.setHeader("content-disposition", "attachment;filename="+filename);
		response.setHeader("content-type","image/jpeg");
		
		//3.���������ʽ
		int len = 1;
		byte[] b = new byte[1024];
		while((len=fis.read(b))!= -1){
			sos.write(b, 0, len);
		}
		
		//�ر���
		sos.close();
		fis.close();
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
