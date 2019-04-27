package com.itheima.web.action;

import java.util.ArrayList;
import java.util.List;

import com.itheima.web.domain.Student;
import com.opensymphony.xwork2.ActionSupport;

public class ActionContextDemo3 extends ActionSupport {
	/**
	 *   container	There is no read method for container
	 *   没有信息存进去 --- 没有getset方法
	 *   只要有参数，就要设置getset方法！
	 */
	private List<Student> students;
	
	public String iteratorDemo(){
		
		students = new ArrayList<Student>();
		students.add(new Student("zhangsan",23));
		students.add(new Student("lisi",21));
		students.add(new Student("wangwu",24));
		
		return SUCCESS;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
