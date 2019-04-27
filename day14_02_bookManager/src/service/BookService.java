package service;

import java.sql.SQLException;
import java.util.List;

import domain.Book;
import domain.PageBean;

public interface BookService {
	
	public List<Book> findAllBooks() throws SQLException;
	
	public void addBook(Book book) throws SQLException;

	public Book findBookById(String id) throws SQLException;

	public void updateBook(Book book) throws SQLException;

	public void delBook(String id) throws SQLException;

	public void delAllBooks(String[] ids);

	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice);

	public PageBean findBooksPage(int currentPage, int pageSize);

	public List<Object> findBookByName(String name);

	

}
