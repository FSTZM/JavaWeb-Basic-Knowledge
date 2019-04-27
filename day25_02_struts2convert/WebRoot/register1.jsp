<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%--导入Struts的标签库 --%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户注册，使用Struts的标签</title>

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

	<!-- 字段错误 -->
	<s:fielderror/> <!-- Invalid field value for field "birthday" -->

	<!-- 动作错误 -->
	<s:actionerror/>
	
	<!-- strtus2的form标签，它提供了和原始HTML表单标签几乎一致的属性 
		action:请求的地址。可以直接写动作名称。不用谢context
		method:请求的方式。在这里不用写。strtus的form表单默认是post
		enctype:表单编码的MIME(多用途互联网邮件扩展类型)类型
		
		requiredLabel:必填项
		showPassword:把密码信息带回来(刷新还在)
	-->
	<s:form action="register.action">
		<s:textfield name="username" label="用户名" requiredLabel="true" requiredPosition="left"></s:textfield>
		<s:password name="password" label="密码" showPassword="true"></s:password>
		<s:textfield name="birthday" label="生日"></s:textfield>
		<s:submit></s:submit>
	</s:form>

	<form action="${pageContext.request.contextPath }/register.action"
	method="post"> 
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
