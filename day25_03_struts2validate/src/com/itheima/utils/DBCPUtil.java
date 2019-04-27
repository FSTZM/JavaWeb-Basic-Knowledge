package com.itheima.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtil {
  
	//1.����һ������Դ
	private static DataSource ds;
	
	//2.ʹ�þ�̬����飬������Դ��ֵ
	static{
		try {
			Properties prop = new Properties();
			InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化连接池失败！");
		}
	}
	
	
	
	//3.提供一个获取数据源的方法
	public static DataSource getDataSource(){
		return ds;
	}
	
	//4.提供一个获取连接的方法。注意：以后获取连接必须使用该方法。
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
