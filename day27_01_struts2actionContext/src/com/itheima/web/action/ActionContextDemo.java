package com.itheima.web.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionContextDemo extends ActionSupport {
	
	public String actionContext(){
		
		ActionContext context = ActionContext.getContext();
		context.put("contextMap", "hello contextMap");//把数据直接存到了大Map中
		Map<String, Object> contextMap = context.getContextMap();
		contextMap.put("contextMap1", "hello contextMap1");
		
		//法一：根据大map context的key获取小map
		Map<String, Object> sessionAttribute = context.getSession();
		sessionAttribute.put("sessionMap", "hello sessionMap");
		
		//法二：根据原始的方法获取session
		HttpSession sessionAttribute1 = ServletActionContext.getRequest().getSession();
		sessionAttribute1.setAttribute("sessionMap1", "hello SessionMap1");
		
		
		
		return SUCCESS;
	}

}
