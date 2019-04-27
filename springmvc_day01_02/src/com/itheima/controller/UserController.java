package com.itheima.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.domain.User;

@Controller // 相当于在spring中写入了一条bean
// @RequestMapping("/user")//设置根路径来隔离，防止不同controller中同名的方法产生调用冲突
public class UserController {

	@RequestMapping("hello")
	public String myHello() {

		return "hello";
	}

	// 设置跳转路径，因为jsp是在WEB-INF下
	// 在URL中输入 toAdd.do 跳转到add.jsp页面
	@RequestMapping("toAdd")
	public String toAdd() {
		return "add";
	}

	@RequestMapping("recrviceInt")
	public String recrviceInt(int id) {

		System.out.println(id);

		return "success";
	}

	@RequestMapping("addList")
	public String addList(Model model) {

		List<User> list = new ArrayList<User>();

		User user1 = new User();
		user1.setId("1");
		user1.setUsername("zhangsan");
		user1.setSex("male");
		user1.setAddress("beijing");

		User user2 = new User();
		user2.setId("2");
		user2.setUsername("lisi");
		user2.setSex("male");
		user2.setAddress("xinzhou");

		User user3 = new User();
		user3.setId("3");
		user3.setUsername("wangwu");
		user3.setSex("famale");
		user3.setAddress("xian");

		list.add(user1);
		list.add(user2);
		list.add(user3);

		model.addAttribute("list", list);

		return "success";
	}

	// 普通写法
	@RequestMapping("update")
	public String update(String id) {
		// 重定向
		System.out.println(id);
		return "redirct:addList.do";
	}

	// 避免URL中后面跟一堆id=?
	//相应的 jsp 页面中要修改为：
	//		<a href="${ pageContext.request.contextPath}/update/${user.id}.do">修改</a>
	@RequestMapping("update/{id}")
	public String update1(@PathVariable String id) {
		// 重定向
		System.out.println(id);
		return "redirct:addList.do";
	}
	
	
	//restfull开发风格
	//首先需要在web.xml中配置:<url-pattern>/rest/*</url-pattern>
	//其次需要在jsp页面中进行配置：
	//			<a href="${ pageContext.request.contextPath}/rest/update/${user.id}">修改</a>
	@RequestMapping("update/{id}")
	public String update2(@PathVariable String id) {
		// 重定向
		System.out.println(id);
		return "redirct:/rest/addList.do";
	}
	

}
