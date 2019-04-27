<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!-- 出现报错的原因：
	1.需要引入jstl库
	2.uri地址后面需要加rt -->
<!-- https://blog.csdn.net/f9inux/article/details/1368428 -->

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '1.jsp' starting page</title>
    
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
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("eee");
		list.add("fff");
		
		request.setAttribute("list", list);
	 %>
	 
	<table border="1">
		<tr>
			<th>数据</th>
			<th>索引</th>
			<th>计数</th>
			<th>第一个</th>
			<th>最后一个</th>
		</tr>
		
		<c:forEach items="${list }" var="l" varStatus="vs">
		<%-- 事实上定义了一个status名的对象作为varStatus的绑定值。该绑定值也就是status封装了当前遍历的状态，
		比如，可以从该对象上查看是遍历到了第几个元素：${status.count} --%>
		
			<tr ${vs.count%2==1 ? "style='background-color:lime'" : "style='background-color:green'"}>
				
				<td>${l }</td>
				<td>${vs.index }</td>
				<td>${vs.count }</td>
				<td>${vs.first }</td>
				<td>${vs.last }</td>
			</tr>
		
		</c:forEach>
		
	
	</table>
	



  </body>
</html>
