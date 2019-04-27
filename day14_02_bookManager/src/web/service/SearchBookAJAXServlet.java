package web.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.impl.BookServiceImpl;

public class SearchBookAJAXServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	
		
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"),"UTF-8");
		
		BookService bs = new BookServiceImpl();
		List<Object> list = bs.findBookByName(name);
		
		//把集合中的数组作为字符串返回到网页
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			if(i>0){
				str = str+",";
			}
			str = str+list.get(i);
		}
		
		//分发转向--把数据直接响应到客户端
		response.getWriter().write(str);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
