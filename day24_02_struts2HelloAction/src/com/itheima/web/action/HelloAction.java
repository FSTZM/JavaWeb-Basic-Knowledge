package com.itheima.web.action;

public class HelloAction {   //动作类
	/**
	 * 在动作类中的指定的动作方法
	 * 动作方法的书写要求：
	 * 		1、都是public
	 * 		2、返回值都是string
	 * 		3、必须没有参数
	 * 
	 * @return
	 */

	/**
	 * Exception
	 * 
	 * tomcat导入项目的时候 项目后面有个括号
	 * 名字没改对，打开项目目录下的.project文件。名字改成一致的就行了。
	 * 或者在工程目录上右键, 选properties, 弹出属性窗口, 选中Web Project Settings, 在右边的Context root中修改保存即可
	 * @return
	 */
	
	
	public String sayHello(){
		System.out.println("sayHello 方法执行");
		return "success"; //与配置文件中的result中的name对应
	}
	
}
