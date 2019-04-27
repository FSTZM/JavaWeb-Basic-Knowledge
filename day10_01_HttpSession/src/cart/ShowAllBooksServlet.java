package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Book;
import util.DButils;

public class ShowAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("本网站有以下书籍：");
		out.write("<br/>");
//		HttpSession session = request.getSession();
		Map<String,Book> books = DButils.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			String url1 = request.getContextPath()+"/servlet/AddCart?id="+book.getKey();
			out.write("<a href='"+response.encodeURL(url1)+"' targrt='_blank'>"+book.getValue().getName()+"</a><br/>");
		}
		
		out.write("<hr/>");
		
		String url2 = request.getContextPath()+"/servlet/ShowCart";
		out.write("<a href='"+response.encodeURL(url2)+"'>查看购物车</a>");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
