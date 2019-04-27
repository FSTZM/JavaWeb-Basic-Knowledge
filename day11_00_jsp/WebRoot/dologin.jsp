<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dologin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	
    	//获取表单数据
    	String userName = (String)request.getParameter("userName");
    	String pwd = (String)request.getParameter("pwd");
    	
    	//处理业务逻辑
    	//分发转向
    	if("tom".equals(userName) && "123".equals(pwd)){
    		request.getRequestDispatcher("/success.jsp").forward(request, response);
    	}else{
    		request.setAttribute("msg", "用户名或者密码不正确！");
    		request.getRequestDispatcher("/login.jsp").forward(request, response);;
    	}
    	
     %>
  </body>
</html>
