package com.itheima.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private IUserService us = new UserServiceImpl();
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}
	
	//------------用户登录------------
	public String login(){
		
		User dbUser = us.login(user.getLogonName(), user.getLogonPwd());
		
		if(dbUser == null){
			addActionError("用户名或密码不正确！请重新输入！");
			return "input";
		}
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);
		
		return SUCCESS;
	}
	
	//------------添加用户--------------
	/*
	 * new File(String pathname);通过将给定路径来创建一个新File实例。
	 * new File(String parent, String child); 根据parent路径名字符串和child路径名创建一个新File实例。
	 */
	private File upload;
	private String uploadFileName;
	
	public String add(){
		
		//1.获取路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/files");
		String dir = generateChildPath(realPath);
		//2.生成带有随机性的文件名
		String fileName = TokenHelper.generateGUID() + "_" +uploadFileName;
		//3.填充user中需要的path和filename参数
		user.setPath(dir);
		user.setFilename(fileName);
		//4.上传文件
		upload.renameTo(new File(realPath+File.separator+dir,fileName));
		//5.添加用户
		int res = us.saveUser(user);
		if(res > 0){
			return SUCCESS;
		}
		return null;
		
	}

	private String generateChildPath(String realPath) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dir = format.format(date);
		File file = new File(realPath,dir);
		if(!file.exists()){
			file.mkdirs();
		}
		return dir;
	}
	
	//---------查询所有用户------------
	private List<User> users;
	
	public String findAll(){
		users = us.findAllUser();
		return SUCCESS;
	}
	
	//---------根据用户ID查找用户------------
	public String findUserById(){
		
		user = us.findUserById(user.getUserID());
		
		//栈顶的user是模型驱动的user，而view中取值要从栈顶取值，此时查找到的user是domain中的
		//解决办法：1.在view.jsp中[1].userName  2.把domain中的user压入栈顶
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		
		return SUCCESS;
	}
	
	//----------文件下载------------
	private InputStream inputStream;
	private String oldFileName;
	public String download(){
		//1.获取用户信息
		User dbUser = us.findUserById(user.getUserID());
		//2.设置文件存放的路径,文件存储的名字
		String realPath = ServletActionContext.getServletContext().getRealPath("/files");
		oldFileName = dbUser.getFilename().substring(dbUser.getFilename().indexOf("_")+1);
		
		//3.给字节流赋值
		try {
			inputStream = new FileInputStream(realPath+File.separator+dbUser.getPath()+File.separator+dbUser.getFilename());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//4.返回成功
		System.out.println(oldFileName);
		return SUCCESS;
		//5.剩下的交给stream结果视图
	}

	//-----------删除用户-------------
	public String delete(){
		int res = us.removeUser(user.getUserID());
		if(res > 0){
			return SUCCESS;
		}
		return null;
	}
	
	//----------显示编辑用户信息页面----------
	public String editUI(){
		user = us.findUserById(user.getUserID());
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	
	//-----------编辑用户----------
	public String edit(){
		
		/*
		 * 判断用户是否重新选择了文件
		 * 1.没有选择文件。我们就用原来的
		 * 2.重新走一遍文件下载上传程序 
		 */
		
		if(upload == null){
			//由于没有选择文件，user模型中的filename和path属性都是null，我们需要用查出来的用户里面的值替换
			//空指针异常：没有查找到dbUser，因为form表单没有提供userID
			User dbUser = us.findUserById(user.getUserID());
			user.setFilename(dbUser.getFilename());
			user.setPath(dbUser.getPath());
			
			int res = us.modifyUser(user);
			if(res > 0){
				return SUCCESS;
			}
		}else{
			//没有重新上传文件，获取之前的文件
			//1.获取路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/files");
			String dir = generateChildPath(realPath);
			//2.生成带有随机数字的文件名
			String fileName = TokenHelper.generateGUID() + "_" + uploadFileName;
			//3.填充user中的属性
			user.setFilename(fileName);
			user.setPath(dir);
			//4.上传文件
			upload.renameTo(new File(realPath+File.separator+dir,fileName));
			//5.保存用户
			int res = us.modifyUser(user);
			if(res > 0){
				return SUCCESS;
			}
		}
		return null;
	}
	
	//------------按条件查找用户----------------
	private String isUpload;
	public String findUserByCondition(){
		users = us.findUserByCondition(user.getUserName(), user.getGender(), user.getEducation(), isUpload);
		return SUCCESS;
	}
	
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getOldFileName() throws UnsupportedEncodingException {
		
//		return new String(oldFileName.getBytes("ISO8859-1"), "utf-8");
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {

		this.oldFileName = oldFileName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() throws UnsupportedEncodingException {
//		return new String(uploadFileName.getBytes("ISO8859-1"), "utf-8");
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
	
}
