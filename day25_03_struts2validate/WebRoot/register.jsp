<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

	<!-- strtus2的form标签，它提供了和原始HTML表单标签几乎一致的属性 
		action:请求的地址。可以直接写动作名称。不用谢context
		method:请求的方式。在这里不用写。strtus的form表单默认是post
		enctype:表单编码的MIME(多用途互联网邮件扩展类型)类型
		
		requiredLabel:必填项
		showPassword:把密码信息带回来(刷新还在)
	-->
	<s:form action="register.action">
		<s:textfield name="username" label="用户名" requiredLabel="true"
			requiredPosition="right"></s:textfield>
		<s:password name="password" label="密码" showPassword="true"></s:password>
		<s:textfield name="birthday" label="生日"></s:textfield>
		<s:submit value="注册"></s:submit>
	</s:form>


</body>
</html>
