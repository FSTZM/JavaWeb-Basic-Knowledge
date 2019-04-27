package web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * 参考资料：https://blog.csdn.net/u013248535/article/details/55823364/
 * @author Diane
 */

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//执行文件上传操作
		//判断表单是否支持上传
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if(!isMultipartContent){
			throw new RuntimeException("不是可以提交的表单类型数据！");
		}else{
			//创建一个DiskFileItemFactory工厂类
			DiskFileItemFactory factory = new DiskFileItemFactory();	
			//创建一个ServletFileUpload
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			//解析(parse)request对象得到表单对象的集合
			try {
				//遍历表单数据
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					if(fileItem.isFormField()){
						processFormField(fileItem);
					}else{
						processUploadField(fileItem);
					}
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
				
		}
		
		
	}

	//上传表单项
	private void processUploadField(FileItem fileItem) {
		//得到文件名字
		String filename = fileItem.getName(); //文件名称
		
		try {
			//得到文件输入流
			InputStream is = fileItem.getInputStream();
			
			//通过文件输出流将上传的文件保存到磁盘
			//1.创建一个文件存盘的目录 --- 获取存盘的绝对路径
			String directoryRealPath = this.getServletContext().getRealPath("/upload");
			File storeDirectory = new File(directoryRealPath); //存盘目录
			if(!storeDirectory.exists()){
				storeDirectory.mkdirs();
			}
			//2.在该目录下创建完整目录下的文件
			File file = new File(storeDirectory,filename);
			
			//3.输出
			FileOutputStream fos = new FileOutputStream(file);
			
			int len = 0;
			byte[] b = new byte[1024];
			while((len=is.read(b))!=-1){
				fos.write(b, 0, len);
			}
			
			is.close();
			fos.close();
			
			fileItem.delete();//清理临时缓存文件
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//普通表单项
	private void processFormField(FileItem fileItem) {

		String fieldName = fileItem.getFieldName();
		String fileValue = null;
		try {
			fileValue = fileItem.getString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fieldName+":"+fileValue);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
