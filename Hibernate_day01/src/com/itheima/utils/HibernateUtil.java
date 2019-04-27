package com.itheima.utils;

//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/*
 * 1.servlet的HttpSession与HibernateSession的区别?
 * 		(1)javax.servlet.http.HttpSession是一个抽象接口
 * 			它的产生:J2EE的Web程序在运行的时候,会给每一个新的访问者建立一个HttpSession,这个Session是用户身份的唯一表示。注意,是容器(Tomcat,Resin)自动创建的。
 * 			用途:存放这个用户的一些经常被用到的信息,例如:用户名,权限。例如在购物车程序里,存放用户买的商品。
 * 			销毁:一定时间(跟容器有关)内,用户无任何动作,session自动销毁。
 * 		(2)它是hibernate操作数据库的一个句柄对象。它跟上面那个Session唯一的相似处就是名字有点像,其他没任何一样的地方。
 * 			亦可以理解为数据库层和持久化层的互访载体，也可以认为是一个缓冲器，对数据库的所有CURD操作在这个session（缓存）中都有记录
 * 			一旦做个缓存commit操作，则所有对持久化对象的操作都将映射到具体的某个数据库中，完成最后的数据更新
 * 
 * 		   Session对象：使用hibernate进行数据库操作，主要使用session。
 * 			Session可以理解为对Connection对象的一个包装。Session对象中提供了对数据库的crud操作。
 * 			Session是一个线程不安全的对象，生命周期非常短暂，一般和事务一一对应。
 * 			Session又称为hibernate中的一级缓存。使用完马上关闭就是为了防止线程不安全问题。
 * 
 * 2.HibernateAPI中的两个Session有什么区别? --- org.hibernate.Session/org.hibernate.classic.Session;
 * 		org.hibernate.Session指的是hibernate3.0的版本
 * 		org.hibernate.classic.Session是为了支持hibernate2.0版本的延续
 * 
 * 		在 Hibernate3.0中，org.hibernate.classic.Session接口继承了org.hibernate.Session接口，
 * 	在org.hibernate.classic.Session接口中包含了一系列被废弃的方法，如find()、interate()等
 */

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	//静态代码块先加载配置文件
	static{
		Configuration conf = new Configuration().configure();
		sessionFactory = conf.buildSessionFactory();
		//关闭资源
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				sessionFactory.close();
			}
		}));
		
	}
	
	//重写方法
	public static Session openSession(){
		Session session = sessionFactory.openSession();
		return session;
	}
	
	public static Session getCurrentSession(){
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	
}
