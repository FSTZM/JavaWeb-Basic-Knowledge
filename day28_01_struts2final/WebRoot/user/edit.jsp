<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		<!-- language="javascript"，不建议使用。现在使用的是 type="text/javascript"-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
		<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.4.2.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick-zh-CN.js"></script>
	</HEAD>
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#birthday').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
	<body>
		<s:form action="edit.action" namespace="/user" enctype="multipart/form-data" id="userAction_save_do" name="Form1">
			&nbsp;
			<!-- 没有提供userID信息 -->
			<input type="hidden" name="userID" value="<s:property value="userID"/>">
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加用户</STRONG></strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						登录名：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<s:textfield name="logonName"  cssClass="bg"></s:textfield>
						<!-- <input type="text" name="logonName" value="" id="userAction_save_do_logonName" class="bg"/> -->
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 密码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:password name="logonPwd"  showPassword="true"></s:password>
						<!-- <input type="password" name="logonPwd" value="" id="logonPwd"/> -->
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						用户姓名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="userName"  cssClass="bg"></s:textfield>
						<!-- <input type="text" name="userName" value="" id="userAction_save_do_userName" class="bg"/> -->
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						性别：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:radio  name="gender" list="{'男','女'}"></s:radio>
						<!-- <input type="radio" name="sex" id="sex男" value="男"/><label for="sex男">男</label>
						<input type="radio" name="sex" id="sex女" value="女"/><label for="sex女">女</label> -->

					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						学历：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:select name="education" list="{'研究生','本科','专科','高中','初中','小学'}" headerKey="" headerValue="---选择学历---"></s:select>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						出生日期：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="birthday" size="20" readonly="readonly" id="birthday"></s:textfield>
						<%-- <s:textfield name="birthday" size="20" value="" readonly="readonly" ></s:textfield> --%>
						<!-- <input type="text" name="birthday" size="20" value="" readonly="readonly" id="birthday"/> -->
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						电话：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<s:textfield name="telephone" ></s:textfield>
						<!-- <input type="text" name="telephone" value="" id="telephone"/> -->
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						兴趣爱好：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:checkboxlist name="hobby" list="{'看电影','旅游','健身','购物','读书','睡觉'}" value="hobby.split(', ')"></s:checkboxlist>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						简历资料：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<!-- 在编辑页面显示下载的文件名 -->
						<s:url action="download" namespace="/user" var="url">
							<s:param name="userID" value="userID"></s:param>
						</s:url>
						<a href="#" onclick="openWindow('<s:property value="#url" />','700','400')" class="cl_01">
							<s:property value="filename.substring(filename.indexOf('_')+1)"/>
						</a>
						<!-- 重新上传 与 取消上传功能  要用到div中的display功能-->
						<div id="mydiv" style="display:none">
							<s:file name="upload" size="30"></s:file>
						</div>
						<input type="button" value="重新上传" onclick="showFile()" id="showBtn">
						<input type="button" value="取消上传" onclick="cancelFile()" id="cancelBtn" style="display:none">
						
						<script type="text/javascript">
							function showFile(){
								var mydiv = document.getElementById("mydiv");
								var showBtn = document.getElementById("showBtn");
								var cancel = document.getElementById("cancelBtn");
								mydiv.style.display = 'inline';
								showBtn.style.display = 'none';
								cancelBtn.style.display = 'inline';
							}
							
							function cancelFile(){
								var mydiv = document.getElementById("mydiv");
								var showBtn = document.getElementById("showBtn");
								var cancel = document.getElementById("cancelBtn");
								mydiv.style.display = 'none';
								showBtn.style.display = 'inline';
								cancelBtn.style.display = 'none';
							}
						</script>
						
						<!-- <input type="file" name="upload" size="30" value="" id="userAction_save_do_upload"/> -->
					</td>
				</tr>
				<TR>
					<TD class="ta_01" align="center" bgColor="#f5fafe">
						备注：
					</TD>
					<TD class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:textarea name="remark" cols="30" rows="3" cssStyle="WIDTH: 96%"></s:textarea>
						<!-- <textarea name="remark" cols="30" rows="3" id="userAction_save_do_remark" style="WIDTH: 96%"></textarea> -->
					</TD>
				</TR>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>


				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" name="submit" value="&#30830;&#23450;" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="&#37325;&#32622;" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</HTML>