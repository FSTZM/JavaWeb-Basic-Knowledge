<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>s:iterator的使用</title>
  </head>
  <body>
  	<table width="500px" border="1" align="center">
  		<tr>
  			<th>序号</th>
  			<th>姓名</th>
  			<th>年龄</th>
  		</tr>
  		<%--s:iterator：struts2的迭代标签
  			属性详解：
  			begin,end,step和jstl的forEach标签是一样的 
  			value属性：要遍历的集合，是OGNL表达式。
  			var属性：取值就是一个字符串
  				如果写了该属性：把var的值作为key，把当前遍历的元素作为value。存到ActionContext这个大Map中
  				如果不写该属性：把当前遍历的元素压入栈顶
  			status属性：遍历时的一些计数信息。
  				int getIndex() 从0开始
  				int getCount() 从1开始
  				boolean isFirst() 
  				boolean isLast()
  				boolean isOdd()
  				boolean isEven()
  			--%>
  		<s:iterator value="students" var="s" status="vs" >
  			<tr>
  				<td><s:property value="#vs.index"/></td>
  				<td><s:property value="#s.name" /></td>
  				<td><s:property value="#s.age" /></td>
  			</tr>
  		</s:iterator>
  	</table>
  	<hr/>
  		<table width="500px" border="1" align="center">
  		<tr>
  			<th>序号</th>
  			<th>姓名</th>
  			<th>年龄</th>
  		</tr>
  		<s:iterator value="students" status="vs">
  			<tr>
  				<td><s:property value="#vs.count"/></td>
  				<td><s:property value="name" /></td>
  				<td><s:property value="age" /></td>
  			</tr>
  		</s:iterator>
  	</table>
  	<%--OGNL的投影：(以下内容全是了解)添加过滤条件 
  		a.“?#”：过滤所有符合条件的集合，如：users.{?#this.age > 19}   
  		b.“^#”：过滤第一个符合条件的元素，如：users.{^#this.age > 19}    
  		c.“$#”：过滤最后一个符合条件的元素，如：users.{$#this.age > 19}
  	--%>
  	<hr/>
  		<table width="500px" border="1" align="center">
  		<tr>
  			<th>序号</th>
  			<th>姓名</th>
  			<th>年龄</th>
  		</tr>
  		<s:iterator value="students.{?#this.age>21}" status="vs">
  			<tr>
  				<td><s:property value="#vs.count"/></td>
  				<td><s:property value="name" /></td>
  				<td><s:property value="age" /></td>
  			</tr>
  		</s:iterator>
  	</table>
  	<%--OGNL的投影：指定输出内容 
  		students.{name}========{"name1","name2","name3"}
  	--%>
  	<hr/>
  		<table width="500px" border="1" align="center">
  		<tr>
  			<th>序号</th>
  			<th>姓名</th>
  			<th>年龄</th>
  		</tr>
  		<s:iterator value="students.{name}" status="vs" >
  			<tr>
  				<td><s:property value="#vs.count"/></td>
  				<td><s:property /></td>
  				<td><s:property /></td>
  			</tr>
  		</s:iterator>
  	</table>
  	<s:debug/>
  </body>
</html>
