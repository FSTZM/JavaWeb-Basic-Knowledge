package c_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.utils.HibernateUtils;

public class demo1 {

	@Test
	// Hql查询所有
	public void fun1() {

		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		// ---------------------------------------------

		Query query = session.createQuery("from Customer");
		List list = query.list();
		System.out.println(list);

		// ---------------------------------------------
		session.getTransaction().commit();
		session.close();

	}

	@Test
	// Hql查询对象的某几个属性
	public void fun2() {

		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		// ---------------------------------------------

		Query query = session.createQuery("select c.name from Customer c");
		List list = query.list();
		System.out.println(list);

		// ---------------------------------------------
		session.getTransaction().commit();
		session.close();

	}

	@Test
	// 投影查询
	// 选择查询的基础上,想把查询结果封装到对象中
	//封装到对象中，要new一个对象，并且构造相应的函数
	//select new Customer(c.id,c.name) from Customer c
	//其中（）中的数据要对应构造函数中的参数
	public void fun3() {

		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		// ---------------------------------------------

		Query query = session.createQuery("select new Customer(c.id,c.name) from Customer c");
										
		List<Customer> list = query.list();
		System.out.println(list);

		// ---------------------------------------------
		session.getTransaction().commit();
		session.close();

	}
	
	@Test
	// 分页
	public void fun4() {

		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		// ---------------------------------------------

		Query query = session.createQuery("from Customer c order by c.id asc");
		
		query.setFirstResult(1);//从哪个索引开始取数据,包括索引本身的记录
		query.setMaxResults(1);//查询出多少条数据
										
		List<Customer> list = query.list();
		System.out.println(list);

		// ---------------------------------------------
		session.getTransaction().commit();
		session.close();

	}
	
	@Test
	// 排序
	// 升序 asc   降序 desc
	public void fun5() {

		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		// ---------------------------------------------

		Query query = session.createQuery("from Customer c order by c.id desc");
										
		List<Customer> list = query.list();
		System.out.println(list);

		// ---------------------------------------------
		session.getTransaction().commit();
		session.close();

	}
	
	@Test
	// 绑定参数
	public void fun6(){
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		//------------------------------------------------
		
		Query query = session.createQuery("from Customer c where c.id = ? ");
		//参数1:?占位符的索引 ,第一个问好索引为0
		query.setInteger(0,2);
		
		/*Query query = session.createQuery("from Customer c where c.id = :haha ");
		//参数1: 参数占位符的名称
		query.setInteger("haha",2);*/
		
		
		Customer c = (Customer) query.uniqueResult();
		
		System.out.println(c);
		//------------------------------------------------
		session.getTransaction().commit();
		session.close(); // 游离状态
	}
	

	@Test
	// 聚合函数
	public void fun7(){
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		//------------------------------------------------
		//Query query = session.createQuery(" select count(*) from  Customer c ");
		//Query query = session.createQuery(" select avg(c.id) from  Customer c ");
		//Query query = session.createQuery(" select sum(c.id) from  Customer c ");
		//Query query = session.createQuery(" select max(c.id) from  Customer c ");
		Query query = session.createQuery(" select min(c.id) from  Customer c ");
		Object count = query.uniqueResult();
		System.out.println(count);
		//------------------------------------------------
		session.getTransaction().commit();
		session.close(); // 游离状态
	}
	
	@Test
	// 分组
	// group by .. having..
	public void fun9(){
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		//------------------------------------------------
		Query query = session.createQuery(" select o.customer, count(o) from Order o group by o.customer  having count(o) > 2 ");
	
		List<Object[]> list= query.list();
		
		for(Object[] objs : list){
			System.out.println(Arrays.toString(objs));
		}
		
		//------------------------------------------------
		session.getTransaction().commit();
		session.close(); // 游离状态
	}
	

}
