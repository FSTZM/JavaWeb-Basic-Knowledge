<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>student page</title>
    
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
  
  	<!-- 密码验证是验证器验证，出错了是动作错误 -->
  	<s:actionerror/>
  
    <s:form action="addStudent.action">
    	<s:textfield name="username" label="用户名" />
  		<s:textfield name="age" label="年龄"/>
  		<s:textfield name="email" label="邮箱"/>
  		<s:textfield name="password" label="密码" />
  		<s:textfield name="repassword" label="确认密码"/>
  		<s:textfield name="score" label="成绩"/>
  		<s:textfield name="url" label="个人主页"/>
  		<s:radio  name="gender" list="{'男','女'}"></s:radio>
  		<s:submit value="注册"/>
    </s:form>
  </body>
</html>
