package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class demo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//
		String name = request.getParameter("name");
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		
		//ªÒ»°session
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		response.getWriter().write(session.getId());
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
