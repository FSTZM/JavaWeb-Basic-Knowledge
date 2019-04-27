<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
    <<table border="1">
    	<tr>
    		<td>姓名</td>
    		<td>年龄</td>
    		<td>性别</td>
    		<td>地址</td>
    		<td>备注</td>
    	</tr>
    	
    	<c:forEach items="${list }" var="user">
    		<tr>
    		<td>${user.id }</td>
    		<td>${user.username }</td>
    		<td>${user.sex }</td>
    		<td>${user.address }</td>
    		<td>
    			<a href="${ pageContext.request.contextPath}/rest/update/${user.id}">修改</a>
    		</td>
    	</tr>
    	</c:forEach>
    	
    </table>
  </body>
</html>
