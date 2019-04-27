package web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.impl.BookServiceImpl;

public class DelAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] ids = request.getParameterValues("ids");
		//�õ���ѡ���ֵ��value������������name������������Ҫ�� name="",values=""
		/*Parameters:name a String containing the name of the parameter whose value is requested
		Returns:an array of String objects containing the parameter's values*/	
		
		BookService bs = new BookServiceImpl();
		bs.delAllBooks(ids);
		
		request.getRequestDispatcher("/servlet/bookListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
