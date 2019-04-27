package util;

import java.util.HashMap;
import java.util.Map;

import entity.Book;

public class DButils {
	
	public static Map<String,Book> books = new HashMap<String,Book>();
	
	static{
		books.put("1", new Book("1", "�ֲ˱���", 20, "������"));
		books.put("2", new Book("2", "Ģ����������", 20, "������"));
		books.put("3", new Book("3", "java", 30, "����"));
		books.put("4", new Book("4", "web", 10, "����"));
	}
	
	//�õ�������
	public static Map<String,Book> findAllBooks(){
		return books;
	}
	
	//����ID������
	public static Book findBookById(String id){
		return books.get(id);
	}

}
