package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Book;
import util.DButils;

public class AddCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//根据ID得到书
		String id = request.getParameter("id");
		Book book = DButils.findBookById(id);
		
		//得到session
		HttpSession session = request.getSession();
		List<Book> list = (List<Book>) session.getAttribute("cart");//从session中取得购物车列表
		
		if(list==null){
			list = new ArrayList<Book>();
		}
		list.add(book);
		
		//把list返回到session中
		session.setAttribute("cart", list);
		
		out.write("购买成功！");
		String url = request.getContextPath()+"/servlet/ShowAllBooksServlet";
		response.setHeader("refresh", "3;url="+response.encodeURL(url));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
