package HttpServletRequest;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import org.apache.commons.beanutils.BeanUtils;

import entity.User;

public class demo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		test1(request);	
//		test2(request);
//		test3(request);
//		test4(request);
//		test5(request);
		
	}


	private void test5(HttpServletRequest request) throws UnsupportedEncodingException {
		//测试五：get方式获取
		
		//解决get方式的乱码 --- new String(name.getBytes("iso-8859-1"),"UTF-8")
		//每一行都要如此注释
		
		String userName = request.getParameter("userName");
		userName = new String(userName.getBytes("iso-8859-1"),"UTF-8");
		System.out.println(userName);
	}


	private void test4(HttpServletRequest request) throws UnsupportedEncodingException {
		//方法四：引入jar包
		
		//编码
		request.setCharacterEncoding("UTF-8");
		
		User u = new User();
		System.out.println("数据封装之前：" + u);
		try {
			BeanUtils.populate(u, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数据封装之前：" + u);
	}

	

	private void test3(HttpServletRequest request) throws UnsupportedEncodingException {
		//方法三：得到表单提交所有值得办法(做框架用) --- getParameterMap
		
		//编码
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String[]> map = request.getParameterMap();
		
		User u = new User();
		
		System.out.println("数据封装之前：" + u);
		
		for (Map.Entry<String, String[]> m : map.entrySet()) {
			String key = m.getKey();
			String[] value = m.getValue();
			
			//创建一属性描述器
			PropertyDescriptor pd = null;
			try {
				pd = new PropertyDescriptor(key, User.class);
			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Method setter = pd.getWriteMethod();
			if(value.length == 1){
				try {
					setter.invoke(u, value[0]);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//给一个值的变量赋值
			}else{
				try {
					setter.invoke(u, (Object)value);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//相关于给复选框赋值
			}
			
		}
		
		System.out.println("数据封装之后：" + u);
	}



	private void test2(HttpServletRequest request) throws UnsupportedEncodingException {
		//方法二：获取表单所有的表单name的名字 -- getParamaterNames
		
		//编码
		request.setCharacterEncoding("UTF-8");
		
		Enumeration names = request.getParameterNames();
		
		while(names.hasMoreElements()){
			
			String name = (String) names.nextElement();
			
			String value = (String) request.getAttribute(name);
			
			System.out.println(name + "\t" + value);
		}
	}

	private void test1(HttpServletRequest request) throws UnsupportedEncodingException {
		//方法一：String挨个获取
		
		//编码
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String[] hobbys = request.getParameterValues("hobby");
		String city = request.getParameter("city");
		
		System.out.println(userName);
		System.out.println(pwd);
		System.out.println(sex);
		
		for (int i = 0;hobbys!=null && i < hobbys.length; i++) {
			System.out.println(hobbys[i]);
		}
		
		System.out.println(city);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
 
}
