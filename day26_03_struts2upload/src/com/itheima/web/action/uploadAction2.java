package com.itheima.web.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class uploadAction2 extends ActionSupport {
	private String username;
	private File[] photo;
	
	private String[] photoFileName;
	private String[] photoContentType;
	
	/**
	 * 注意：有private或者action中，记得写get()set()方法
	 * 
	 * 报错如下：
	 *  Struts has detected an unhandled exception:
		Messages: 	
		File: 	com/itheima/web/action/uploadAction2.java
		Line number: 	28
		Stacktraces
		java.lang.NullPointerException
		
		    com.itheima.web.action.uploadAction2.upload2(uploadAction2.java:28)
		    sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		
		File 实例化时传入的参数为null了 
		就是 File f=new File(name); name是null
		
		一般出现这种错误都是程序有问题，或者配置有问题，但是一般来说都是因为运行时遇到了不能识别
		的标识的错误，包括类名，路径名，方法名等。
		
		用private来修饰他们，如此一来其他类则不能对该变量访问。
		这样我们就将这些变量封闭在了类内部，这样就提高了数据的安全性。
	 * @return
	 */
	
	public String upload2(){
		
		ServletContext application = ServletActionContext.getServletContext();
		String realPath = application.getRealPath("/WEB-INF/files");
		File file = new File(realPath);
		if(!file.exists()){
			file.mkdirs();
		}
		
		//把照片复制过来
		for (int i = 0; i < photo.length; i++) {
			photo[i].renameTo(new File(file,photoFileName[i]));
		}
		
		return "input";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File[] getPhoto() {
		return photo;
	}

	public void setPhoto(File[] photo) {
		this.photo = photo;
	}

	public String[] getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String[] getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String[] photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	

}
