package history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import util.DButil;

public class ShowBookDetail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//获取图书详细信息，获得ID
		String id = request.getParameter("id");
		Book book = DButil.getBookByID(id);
		
		out.print(book);
		
		
		//把当前浏览过的书的ID写回到客户端
		String historyBookId = organizeId(id,request);
		Cookie ck = new Cookie("historyBookId",historyBookId);
		
		ck.setPath("/");
		ck.setMaxAge(Integer.MAX_VALUE);
		
		response.addCookie(ck);
		
	}

	private String organizeId(String id, HttpServletRequest request) {
		
		//得到客户端的id
		Cookie[] cookies = request.getCookies();
		if(cookies==null){
			return id;
		}
		
		//查找有没有name叫做historyBookId的cookie
		
		Cookie historyBook = null;
		
		for(int i = 0; i < cookies.length; i++){
			if("historyBookId".equals(cookies[i].getName())){
				historyBook = cookies[i];
			}
		}
		
		//如果没有historyBookId的cookie，则还返回id
		if(historyBook==null){
			return id;
		}
		
		//历史记录长度为3 的处理方式
		String value = historyBook.getValue();
		
		System.out.println(value);
		
		String[] values = value.split("-");
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(values));
		
		if(list.size() < 3){
			if(list.contains(id)){
				list.remove(id);
			}
		}else{
			if(list.contains(id)){
				list.remove(id);
			}else{
				list.removeLast();
			}
		}
		
		list.addFirst(id);
		
		
		//返回
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			
			if(i>0){
				sb.append("-");
			}
			
			sb.append(list.get(i));
		}
		
		System.out.println(sb);
		
		return sb.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
