package util;

import java.util.HashMap;
import java.util.Map;


import entity.Book;

public class DButil {
	
	private static Map<String,Book> books = new HashMap<String, Book>();
	
	static{
		books.put("1", new Book("1", "java", 20, "zhang"));
		books.put("2", new Book("2", "web", 40, "yang"));
		books.put("3", new Book("3", "html", 30, "su"));
		books.put("4", new Book("4", "spring", 10, "diane"));
	}
	
	//得到所有的书
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	
	
	//根据ID查找书
	public static Book getBookByID(String id){
		return books.get(id);
	}
	
}
