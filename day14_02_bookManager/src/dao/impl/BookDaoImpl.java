package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.BookDao;
import domain.Book;
import utils.C3P0Utils;

public class BookDaoImpl implements BookDao{

	@Override
	public List<Book> findAllBooks() throws SQLException{
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
	}

	@Override
	public void addBook(Book book) throws SQLException {
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("insert into book values(?,?,?,?,?,?,?)", book.getId(),book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getImg_path());
		
	}

	@Override
	public Book findBookById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class),id);
		
		
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?", book.getName(),
				book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
		
	}

	@Override
	public void delBook(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		qr.update("delete from book where id=?", id);
		
	}

	@Override
	public void delAllBooks(String[] ids) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{ids[i]};//循环给每个一维数组中的元素赋值，值是id
		}
		qr.batch("delete from book where id=?", params );
		
	}

	@Override
	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from book where 1=1";
		List list = new ArrayList();
		if(!"".equals(id.trim())){
			sql+=" and id like ?"; //  不能在这写%   %'1002'%
			list.add("%"+id.trim()+"%");// '%1002%'
		}
		
		if(!"".equals(category.trim())){
			sql+=" and category=?";
			list.add(category.trim());
		}
		
		if(!"".equals(name.trim())){
			sql+=" and name like ?";
			list.add("%"+name.trim()+"%");
		}
		
		if(!"".equals(minprice.trim())){
			sql+=" and price>?";
			list.add(minprice.trim());
		}
		if(!"".equals(maxprice.trim())){
			sql+=" and price< ?";
			list.add(maxprice.trim());
		}
		
		return qr.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
	}

	@Override
	public int count() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		long l = (long) qr.query("select count(*) from book", new ScalarHandler());
		return (int) l;
	}

	@Override
	public List<Book> findBooks(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select * from book limit ?,?", new BeanListHandler<Book>(Book.class),(currentPage-1)*pageSize,pageSize);
	}

	@Override
	public List<Object> finBookByName(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		return qr.query("select name from book where name like ?", new ColumnListHandler(),"%"+name+"%");
	}

	

}
