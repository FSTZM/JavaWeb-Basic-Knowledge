package web.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import domain.Book;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.UUIDUtils;


public class AddBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		fileUpload.setHeaderEncoding("UTF-8");
		List<FileItem> fileItems = new ArrayList<FileItem>(0);
		try {
			fileItems = fileUpload.parseRequest(request);
			
			Map<String,String[]> map = new HashMap<String, String[]>();
			
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					//普通表单项
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					
					map.put(name, new String[]{value});
					
				}else{
					//上传表单项
					String filename = fileItem.getName();
					InputStream is = fileItem.getInputStream();
					
					//目录
					String directoryRealPath = this.getServletContext().getRealPath("/upload");
					File storeDirectory = new File(directoryRealPath);
					if(!storeDirectory.exists()){
						storeDirectory.mkdirs();
					}
					
					
					File file = new File(storeDirectory,filename);
					
					//上传
					try {
						fileItem.write(new File(storeDirectory,filename));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/*FileOutputStream fos = new FileOutputStream(file);
					
					int len = 0;
					byte[] b = new byte[1024*1024];
					while((len=is.read(b))!=-1){
						fos.write(b, 0, len);
					}*/
					
					is.close();
//					fos.close();
					fileItem.delete();//清理临时缓存文件
					
					map.put(fileItem.getFieldName(), new String[]{filename});
					//fileItem.getFieldName()是jsp中的“name” -- img_path
					//filename是上传文件的名字  a.txt
				}
			}
			
			Book book = new Book();
			
			try {
				BeanUtils.populate(book, map);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			book.setId(UUIDUtils.getUUID());
			
			BookService bs = new BookServiceImpl();
			try {
				bs.addBook(book);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("book", book);
			request.getRequestDispatcher("/servlet/bookListServlet").forward(request, response);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		
		/*request.setCharacterEncoding("UTF-8");
		
	
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			book.setId(UUIDUtils.getUUID());//获取随机生成的ID
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		BookService bs = new BookServiceImpl();
		try {
			bs.addBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("book", book);
		request.getRequestDispatcher("/servlet/bookListServlet").forward(request, response);*/
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
