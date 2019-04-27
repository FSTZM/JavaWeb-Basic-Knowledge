package history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import util.DButil;

public class ShowAllBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		out.write("����վ�������鼮��<br/>");
		Map<String,Book> books = DButil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			out.write("<a href='"+request.getContextPath()+"/servlet/ShowBookDetail?id="+book.getKey()+"' target='_blank'>"+book.getValue().getName()+"</a></br>");
		}
		
		
		out.write("<hr/>");
		out.write("�����¼���£�<br/>");
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			//�ж��Ƿ���historyBookId��cookie
			if("historyBookId".equals(cookies[i].getName())){
				String value = cookies[i].getValue();
				String[] ids = value.split("-");
				for (int j = 0; j < ids.length; j++) {
					//����ID�õ�ָ������
					Book book = DButil.getBookByID(ids[j]);
					out.write(book.getName() + "<br/>");
				}
				
			}
			
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
