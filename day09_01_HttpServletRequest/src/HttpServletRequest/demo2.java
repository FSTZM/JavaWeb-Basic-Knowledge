package HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo2 extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		test1(request);
		
//		test2(request);
		
		
		
	}

	private void test2(HttpServletRequest request) {
		
		Enumeration<String> names = request.getHeaderNames();
		
		while(names.hasMoreElements()){
			String e = names.nextElement();
			System.out.println(e+": "+request.getHeader(e));
			
//			host: localhost:8087
//			user-agent: Mozilla/5.0 (Windows NT 10.0; WOW64; rv:59.0) Gecko/20100101 Firefox/59.0
//			accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//			accept-language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//			accept-encoding: gzip, deflate
//			connection: keep-alive
//			upgrade-insecure-requests: 1
			
		}
	}

	private void test1(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		System.out.println(header);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
