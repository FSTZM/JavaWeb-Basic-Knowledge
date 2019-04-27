package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;


public class autoLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.ת���������� httpServletRequest httpServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//2.����ҵ��
		//�õ�cookies����
		Cookie[] cookies = req.getCookies();
		Cookie ck = null;
		String username = "";
		String password = "";
		//���������ҵ���Ҫ��user����
		for (int i = 0; cookies!=null & i < cookies.length; i++) {
			if("user".equals(cookies[i].getName())){
				ck = cookies[i];
				String str = ck.getValue();
				String[] strs = str.split("&");
				username = strs[0];
				password = strs[1];			
			}
		}
		
		UserService us = new UserService();
		User user = us.findUser(username, password);
		
		//��¼���� -- �����¼�ɹ��Ͱ���Ϣ�ŵ�session��
		if(user!=null){ 
			req.getSession().setAttribute("user", user);
		}

		//3.����
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
