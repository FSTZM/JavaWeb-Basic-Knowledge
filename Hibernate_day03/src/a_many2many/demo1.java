package a_many2many;

import org.hibernate.classic.Session;
import org.junit.Test;

import com.itheima.domain.Course;
import com.itheima.domain.Student;
import com.itheima.utils.HibernateUtils;

public class demo1 {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		//---------------------------------------------
		
		Student stu1 = new Student();
		stu1.setName("tom");
		
		Student stu2 = new Student();
		stu2.setName("jerry");
		
		Course c1 = new Course();
		c1.setName("math");
		Course c2 = new Course();
		c2.setName("struts");
		Course c3 = new Course();
		c3.setName("hibernate");
		
		stu1.getCourses().add(c1);
		stu1.getCourses().add(c2);
		
		stu2.getCourses().add(c1);
		stu2.getCourses().add(c3);
		
		session.save(stu1);
		session.save(stu2);
		
		
		
		//---------------------------------------------
		session.getTransaction().commit();
		session.close();
	}

}
