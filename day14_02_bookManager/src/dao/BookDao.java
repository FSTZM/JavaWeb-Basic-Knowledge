package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Book;

public interface BookDao {
	
	/**
	 * ��������ͼ��
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findAllBooks() throws SQLException;
	
	/**
	 * ���ͼ��
	 * @param book
	 * @throws SQLException
	 */
	public void addBook(Book book) throws SQLException;
	
	/**
	 * ����ID������
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Book findBookById(String id) throws SQLException;

	/**
	 * �޸��鼮��Ϣ
	 * @param book
	 * @throws SQLException 
	 */
	public void updateBook(Book book) throws SQLException;

	/**
	 * ɾ��ͼ��
	 * @param id
	 * @throws SQLException 
	 */
	public void delBook(String id) throws SQLException;

	/**
	 * ����ɾ��ͼ��
	 * @param ids
	 * @throws SQLException 
	 */
	public void delAllBooks(String[] ids) throws SQLException;

	
	/**
	 * ������ѯ
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
	 * ÿҳ���ٱ���
	 * @return
	 * @throws SQLException 
	 */
	public int count() throws SQLException;

	
	/**
	 * ���ҷ�ҳ����
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Book> findBooks(int currentPage, int pageSize) throws SQLException;

	/**
	 * ��������ģ�������鼮
	 * @param name
	 * @return
	 * @throws SQLException 
	 */
	public List<Object> finBookByName(String name) throws SQLException;



}
