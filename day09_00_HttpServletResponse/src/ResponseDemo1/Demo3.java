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

		//1.得到路径 创建输入流
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/桥本环奈.jpg");
		FileInputStream fis = new FileInputStream(path);

		
		//2.创建输出流
		ServletOutputStream sos = response.getOutputStream();
		
		//文件名
		String filename =path.substring(path.lastIndexOf("\\")+1);//电脑上面文件存储的路径是D:\eclipse，是"\"
																//编程时写的是/WEB-INF/classes/桥本环奈.jpg "/"
		//设置文件编码
		filename = URLEncoder.encode(filename,"UTF-8");
		
		//告知客户端要下载文件
		response.setHeader("content-disposition", "attachment;filename="+filename);
		response.setHeader("content-type","image/jpeg");
		
		//3.创建输出方式
		int len = 1;
		byte[] b = new byte[1024];
		while((len=fis.read(b))!= -1){
			sos.write(b, 0, len);
		}
		
		//关闭流
		sos.close();
		fis.close();
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
