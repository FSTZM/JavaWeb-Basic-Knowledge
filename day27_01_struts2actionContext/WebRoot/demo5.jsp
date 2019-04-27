<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>表单</title>
    
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
    <s:form action="saveCustomer.action">
    	<s:textfield name="name" label="姓名"></s:textfield>
    	<s:password name="password" label="密码"></s:password>
    	<s:checkbox name="married" label="已婚" value="false"></s:checkbox>
    	<s:checkboxlist name="hobby" label="爱好" list="#{'photo':'摄影','trip':'旅行','code':'代码' }" ></s:checkboxlist>
<%--    <s:select name="city" label="故乡"  list="#{'BJ':'北京','SH':'上海','SZ':'苏州'}" headerKey="" headerValue="---请选择---"/> --%>
    	<s:select name="city" label="城市"  list="#{'BJ':'北京','SZ':'深圳','XA':'西安'}"  headerKey="" headerValue="---请选择---"></s:select>
    	<s:textarea name="description" label="备注" rows="5" cols="28"></s:textarea>
    	<s:radio name="gender" label="性别" list="#{'male':'男','famale':'女'}" value="'male'"></s:radio>
    	<s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>











