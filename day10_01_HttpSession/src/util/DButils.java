package util;

import java.util.HashMap;
import java.util.Map;

import entity.Book;

public class DButils {
	
	public static Map<String,Book> books = new HashMap<String,Book>();
	
	static{
		books.put("1", new Book("1", "种菜宝典", 20, "蔡美玲"));
		books.put("2", new Book("2", "蘑菇培养技术", 20, "高悠悠"));
		books.put("3", new Book("3", "java", 30, "张三"));
		books.put("4", new Book("4", "web", 10, "李四"));
	}
	
	//得到所有书
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	
	//根据ID查找书
	public static Book findBookById(String id){
		return books.get(id);
	}

}
