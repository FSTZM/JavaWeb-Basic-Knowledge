package com.itheima.web.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class downloadAction extends ActionSupport {
	
	private InputStream inputStream;
	private String filename;
	
	public String download() throws FileNotFoundException{
		
		String realPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files/a.jpg");
		inputStream = new FileInputStream(realPath);
		
		//再返回前规定下载文件的名字
		filename="照片.jpg";
		
		return SUCCESS;
		
		//剩下的事情由Struts2中一个叫stream的结果类型为我们处理
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

}
