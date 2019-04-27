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
 * �ο����ϣ�https://blog.csdn.net/u013248535/article/details/55823364/
 * @author Diane
 */

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ִ���ļ��ϴ�����
		//�жϱ��Ƿ�֧���ϴ�
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if(!isMultipartContent){
			throw new RuntimeException("���ǿ����ύ�ı��������ݣ�");
		}else{
			//����һ��DiskFileItemFactory������
			DiskFileItemFactory factory = new DiskFileItemFactory();	
			//����һ��ServletFileUpload
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			//����(parse)request����õ�������ļ���
			try {
				//����������
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

	//�ϴ�����
	private void processUploadField(FileItem fileItem) {
		//�õ��ļ�����
		String filename = fileItem.getName(); //�ļ�����
		
		try {
			//�õ��ļ�������
			InputStream is = fileItem.getInputStream();
			
			//ͨ���ļ���������ϴ����ļ����浽����
			//1.����һ���ļ����̵�Ŀ¼ --- ��ȡ���̵ľ���·��
			String directoryRealPath = this.getServletContext().getRealPath("/upload");
			File storeDirectory = new File(directoryRealPath); //����Ŀ¼
			if(!storeDirectory.exists()){
				storeDirectory.mkdirs();
			}
			//2.�ڸ�Ŀ¼�´�������Ŀ¼�µ��ļ�
			File file = new File(storeDirectory,filename);
			
			//3.���
			FileOutputStream fos = new FileOutputStream(file);
			
			int len = 0;
			byte[] b = new byte[1024];
			while((len=is.read(b))!=-1){
				fos.write(b, 0, len);
			}
			
			is.close();
			fos.close();
			
			fileItem.delete();//������ʱ�����ļ�
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//��ͨ����
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
