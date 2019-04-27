package e_one2many;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.utils.HibernateUtils;

public class demo2 {
	@Test
	// 增
	// 我们希望在保存Customer时,自动将未保存的Orders当中的Order保存
	// cascade: save-update
	public void fun1() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		// ---------------------------------------------
		Customer c = new Customer();
		c.setName("jack");

		Order o1 = new Order();
		o1.setName("肥皂");

		Order o2 = new Order();
		o2.setName("蜡烛");

		c.getOrders().add(o1);
		c.getOrders().add(o2);

		session.save(c);

		// ---------------------------------------------
		session.getTransaction().commit();
		session.close();

	}

	@Test
	// 增
	// 我们希望在保存Customer时,自动将未保存的Orders当中的Order保存
	// cascade: save-update
	public void fun2() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		// ---------------------------------------------
		Customer c = (Customer) session.get(Customer.class, 4);

		Set<Order> orders = c.getOrders();

		for (Order order : orders) {
			order.setName("new");
		}

		// ---------------------------------------------
		session.getTransaction().commit();
		session.close();

	}

	@Test
	// cascade: delete
	// 删除Customer时 ,会将Customer下的订单一并删除
	// inverse : false 6条sql语句
	// inverse : true 5条sql语句 比上面少一条维护外键

	public void fun3() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		// ------------------------------------------------

		Customer c = (Customer) session.get(Customer.class, 7);// 1条 select

		session.delete(c);// 删除Customer
							// 删除两个Order

		// ------------------------------------------------
		session.getTransaction().commit();

		session.close(); // 游离状态
	}

	@Test
	// cascade: delete
	// 操作的两方cascade值都为delete
	// 需要注意: 千万不要在两方都配置 级联删除. 删除任何一方,会导致整个关系链对象全部删除.
	public void fun4() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		// ------------------------------------------------
		Order o = (Order) session.get(Order.class, 9);// select

		session.delete(o);  // delete删除当前order

							// 找到所有关联的Customer删除 select
							// delete Customer
							// Customer配置了级联删除=> select 找下面的order
							// 删除所有Order
							// 删除Customer

		// ------------------------------------------------
		session.getTransaction().commit();

		session.close(); // 游离状态
	}
	
	@Test
	//inverse:false
	//cascade: delete-orphan 孤儿删除 => 当没有任何外键引用Order时,order 会被删除
	public void fun5(){
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		//------------------------------------------------
			Customer c = (Customer) session.get(Customer.class, 9);
			Iterator<Order> it = c.getOrders().iterator();
			//注意: 删除Customer下的订单时,不能使用 c.setOrders(null); c.setOrders(new HashSet());
			while(it.hasNext()){ // 遍历Customer下的订单,并将订单删除 => 维护关系
				it.next();
				it.remove();
			}
			//------------------------------------------------
			session.getTransaction().commit();
			session.close(); // 游离状态
	}

}
