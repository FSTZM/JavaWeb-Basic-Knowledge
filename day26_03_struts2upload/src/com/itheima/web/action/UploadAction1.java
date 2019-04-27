package com.itheima.web.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction1 extends ActionSupport {

	// 表单上提供的字段
	private String username;
	private File photo;

	// Struts2在文件上传时提供的属性
	private String photoFileName;// 上传的文件名。上传字段名称+FileName 注意大小写
	private String photoContentType; // 上传文件的MIME类型。上传字段名称+ContentType 注意大小写

	public String upload1() {
		//1.拿到ServletContent
		ServletContext application = ServletActionContext.getServletContext();
		//2.调用realPath方法，获取根据一个虚拟目录得到真实的目录
		String realPath = application.getRealPath("/WEB-INF/files");
		File file = new File(realPath);
		//3.如果这个真实的目录不存在，需要创建
		if(!file.exists()){
			file.mkdirs();
		}
		//4.把照片存进去--剪切的方式
		photo.renameTo(new File(file,photoFileName));
		
		
		return "input";

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}



}
