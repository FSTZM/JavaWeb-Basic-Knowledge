package service.impl;

import java.sql.SQLException;
import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import domain.Book;
import domain.PageBean;
import service.BookService;

public class BookServiceImpl implements BookService{
	
	BookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> findAllBooks() throws SQLException {
		return bookDao.findAllBooks();
	}

	@Override
	public void addBook(Book book) throws SQLException {
		bookDao.addBook(book);
	}

	@Override
	public Book findBookById(String id){
		try {
			return bookDao.findBookById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		bookDao.updateBook(book);
		
	}

	@Override
	public void delBook(String id) throws SQLException {
		bookDao.delBook(id);
		
	}

	@Override
	public void delAllBooks(String[] ids) {
		try {
			bookDao.delAllBooks(ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) {
		try {
			return bookDao.searchBooks(id,category,name,minprice,maxprice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean findBooksPage(int currentPage, int pageSize) {
		
		//要返回PageBean,要在其中封装好对象
		int count;
		try {
			count = bookDao.count();
			int totalPage = (int) Math.ceil((count*1.0)/pageSize);
			List<Book> books = bookDao.findBooks(currentPage,pageSize);
			
			//将数据封装到PageBean中
			PageBean pb = new PageBean();
			pb.setCount(count);
			pb.setCurrentPage(currentPage);
			pb.setPageSize(pageSize);
			pb.setTotalPage(totalPage);
			pb.setBooks(books);
			
			//记得返回封装好的数据
			return pb;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Object> findBookByName(String name) {
		try {
			return bookDao.finBookByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
