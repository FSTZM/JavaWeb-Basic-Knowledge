package com.itheima.web.action;

import com.itheima.web.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ActionContextDemo2 extends ActionSupport {
	
	public String valueStack(){
		
		ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();
		
		//栈的操作--压栈
		valueStack.push(new Student("武大",21));//0
		
		/*
		 * ValueStack的其他方法
		 * setValue(String expr,Object value);
		 * 		String expr:它是一个OGNL表达式
		 * 		Object value:我们要操作的数据
		 * 把数据存在哪里？
		 * 		看expr是否使用了#
		 * 			如果使用了#，操作的就是ContextMap
		 * 			如果没有使用#，操作的就是ValueStack
		 * 
		 */
		valueStack.setValue("#name", "张三");//把数据放到ContextMap  key是name value是张三
		valueStack.setValue("name", "李四");// 0 把ValueStack中第一个name的属性的值换成李四。如果没有name属性对应的setName方法，就会报错。
		
		/*
		 *set(String key, Object o);
		 *  String key ： Map的key
		 *  Object o ： map的value
		 *  如果栈顶是一个Map元素,直接把key作为map的key,把Object作为map的value存入。存入的是栈顶。
		 *  如果栈顶不是一个Map元素，创建一个Map对象，把key作为map的key,把Object作为map的value，压入栈顶。
		 */
		valueStack.set("s1", new Student("王五",18));
		valueStack.push(new Student("赵六",23));
		valueStack.set("s2", new Student("七",28));
		
		return SUCCESS;
	}

}
