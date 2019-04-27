<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    
	<form action="${pageContext.request.contextPath }/register.action" method="post">
	
		用户名：<input  type="text" name="username"><br>
		密码：<input  type="password" name="password"><br>
		生日：<input  type="text" name="birthday"><br>
		爱好：<input  type="checkbox" name="hobby" value="吃饭">吃饭
			 <input  type="checkbox" name="hobby" value="睡觉">睡觉
			 <input  type="checkbox" name="hobby" value="游戏">游戏
			 <br>
		婚否：<input  type="radio" name="married" value="true">已婚
			 <input  type="radio" name="married" value="false" checked="checked">未婚
			 <br>
			 
			 <!-- 在数据库中married BOOLEAN 表格中不会乱码
			 		married BIT(1) 会乱码 -->
			 
		<input type="submit" value="注册">
	
	</form>











  </body>
</html>
