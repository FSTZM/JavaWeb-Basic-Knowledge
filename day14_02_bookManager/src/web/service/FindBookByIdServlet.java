package web.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Book;
import service.BookService;
import service.impl.BookServiceImpl;

public class FindBookByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//����
		request.setCharacterEncoding("UTF-8");
		
		//��ȡ������ -- id
		String id = request.getParameter("id");
		
		//����ҵ���߼�
		BookService bs = new BookServiceImpl();
		try {
			Book book = bs.findBookById(id);
			request.setAttribute("book", book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ַ�ת��
		request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
