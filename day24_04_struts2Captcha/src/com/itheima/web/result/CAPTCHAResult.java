package com.itheima.web.result;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

import cn.dsna.util.images.ValidateCode;

/**
 * 自定义结果类型
 * @author Diane
 *
 * 步骤：
 * 	1.编写一个普通类，继承自StrutsResultSupport的类，重写doExecute方法
 * 	2.在Struts.xml中声明结果类型
 * 	3.在配置action时，type属性声明结果类型
 * 
 */
public class CAPTCHAResult extends StrutsResultSupport{

	private int width;
	private int height;
	
	
	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {

		//四个参数
		ValidateCode code = new ValidateCode(width,height,4,10);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		code.write(response.getOutputStream());
		
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


}
