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
		
		//����ID�õ���
		String id = request.getParameter("id");
		Book book = DButils.findBookById(id);
		
		//�õ�session
		HttpSession session = request.getSession();
		List<Book> list = (List<Book>) session.getAttribute("cart");//��session��ȡ�ù��ﳵ�б�
		
		if(list==null){
			list = new ArrayList<Book>();
		}
		list.add(book);
		
		//��list���ص�session��
		session.setAttribute("cart", list);
		
		out.write("����ɹ���");
		String url = request.getContextPath()+"/servlet/ShowAllBooksServlet";
		response.setHeader("refresh", "3;url="+response.encodeURL(url));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
