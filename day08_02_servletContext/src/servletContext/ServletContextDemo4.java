package servletContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//test1();
		//test2();
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/servletContext/c.properties");
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));
		System.out.println(pro.get("key"));
		
	}

	private void test2() throws IOException, FileNotFoundException {
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/b.properties");
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));
		
		System.out.println(pro.get("key"));
	}

	private void test1() throws IOException, FileNotFoundException {
		String path = this.getServletContext().getRealPath("/WEB-INF/a.properties");//参数一定要以/开头
		
		//创建一个properties
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));
		
		
		System.out.println(pro.getProperty("key"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
