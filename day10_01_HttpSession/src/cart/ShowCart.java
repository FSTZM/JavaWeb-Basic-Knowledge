package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Book;

public class ShowCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//得到session
		HttpSession session = request.getSession();
		List<Book> books = (List<Book>) session.getAttribute("cart");
		
		if(books==null){
			out.write("您没有购买记录~");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/ShowAllBooksServlet");
			
			return;//跳出判断
		}
		
		for (Book book : books) {
			out.write(book.getName()+"<br/>");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
