package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Book;

public interface BookDao {
	
	/**
	 * 查找所有图书
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findAllBooks() throws SQLException;
	
	/**
	 * 添加图书
	 * @param book
	 * @throws SQLException
	 */
	public void addBook(Book book) throws SQLException;
	
	/**
	 * 根据ID查找书
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Book findBookById(String id) throws SQLException;

	/**
	 * 修改书籍信息
	 * @param book
	 * @throws SQLException 
	 */
	public void updateBook(Book book) throws SQLException;

	/**
	 * 删除图书
	 * @param id
	 * @throws SQLException 
	 */
	public void delBook(String id) throws SQLException;

	/**
	 * 批量删除图书
	 * @param ids
	 * @throws SQLException 
	 */
	public void delAllBooks(String[] ids) throws SQLException;

	
	/**
	 * 批量查询
	 * @param id
	 * @param category
	 * @param name
	 * @param minprice
	 * @param maxprice
	 * @return 
	 * @throws SQLException 
	 */
	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) throws SQLException;

	/**
	 * 每页多少本书
	 * @return
	 * @throws SQLException 
	 */
	public int count() throws SQLException;

	
	/**
	 * 查找分页数据
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Book> findBooks(int currentPage, int pageSize) throws SQLException;

	/**
	 * 根据名字模糊查找书籍
	 * @param name
	 * @return
	 * @throws SQLException 
	 */
	public List<Object> finBookByName(String name) throws SQLException;



}
