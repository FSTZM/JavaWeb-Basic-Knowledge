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
    
    <title>My JSP 'demo2.jsp' starting page</title>
    
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
  	<!-- 取ValueStack中的对象属性时，不使用#
  		  它是从栈顶逐个查找指定的属性名称。只要找到了就不在继续向下查找
  	 -->
  	<s:property value="name"/><br>
  	<!-- 获得ValueStack中指定位置的属性：使用的是[索引].属性名称
  		https://blog.csdn.net/kato_op/article/details/80275802
  		
  		顺序如下：
  		java.util.HashMap -- 0 
  		com.itheima.web.domain.Student -- 1 
  		java.util.HashMap -- 2 
  		com.itheima.web.domain.Student -- 3
  		
  		map student map student -- 取[0].name,从栈顶开始往下找，第一个name，所以输出：[0].name=赵六
  			赵六			李四		   [1].name时：调用cutStack方法“砍掉”一个索，即map，变成：
  			student map student -- [1].name从栈顶开始往下找name，第一个就是赵六，因此输出：[1].name=赵六
  			赵六			李四		   [2].name时：调用cutStack方法“砍掉”；两个索引，即map，student，变成：
  					map	student -- [2].name从栈顶开始往下找name，第一个就是李四，因此输出：[2].name=李四
  					 	李四		-- [3].name时：调用cutStack方法“砍掉”三个索引，即map，student，map，变成：
  					 	student -- [3].name从栈顶开始往下找name，第一个就是李四，因此输出：[3].name=李四
  					 	李四


  		---------------以下瞎扯----------------
  		
  		索引根据的是[debug]中Value Stack Contents的Object，依次为0,1,2,3...
  		java.util.HashMap -- 0 -- null	
  		com.itheima.web.domain.Student -- 1 -- 赵六
  		java.util.HashMap -- 2 -- null
  		com.itheima.web.domain.Student -- 3 -- 李四
  		
  		value="[0].name"时，按照顺序找到索引为0的name，为空，寻找下一个name 输出赵六
  		value="[1].name"时，按照顺序找到索引为1的name，输出赵六
  		value="[2].name"时，按照顺序找到索引为2的name，为空，寻找下一个name 输出李四
  		value="[3].name"时，按照顺序找到索引为3的name，输出李四
  		
  	 -->
  	<s:property value="[2].name"/><br>
  	<hr>
  	<%--去栈顶map中的元素 --%>
  	<s:property value="s1.name"/><br>
  	<!-- 当s:property什么都不写:
    	  默认取栈顶元素,栈顶元素：Student -->
  	<s:property/>
  	<s:debug></s:debug>
  </body>
  
</html>
