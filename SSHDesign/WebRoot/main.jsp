<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">

<title>主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="main.css">
<link rel="icon" href="res/ic_logo.png" type="image/x-icon"/>

</head>

<body>
	<!-- 修改个人信息的窗体和表单 -->
	<div id="editForm" class="hideform">
		<img class="closeimg" alt="关闭" src="res/ic_close.png" onclick="return closeEdit();">
		<form action="myeditinfo.action" method="post">
			<div class="input">
				<font style="font-size:20px;font: 黑体;font-weight:bold">修改用户信息</font>
				<br><br>
				<input id="password" name="userPass" class="text"
					type="text" placeholder="输入新密码"
					style="background: url(res/ic_lock.png)no-repeat 6px center "
					value="<s:property value="user.userPass"/>"/>
				<br><br>
				<input id="unit" name="userUnit" class="text" type="text"
					placeholder="输入所在单元"
					style="background: url(res/ic_location.png)no-repeat 6px center "
					value="<s:property value="user.userUnit"/>"/>
				<br><br><br>
				<input style="background:#1799ea;" class="button"
					type="submit" value="修改" onclick="return checkForm();">
			</div>
		</form>
	</div>
	
	<div id="container">
		<div id="header">
			<form action="mysearchbooks.action" method="get">
				<div class="header_content" style="left: 30%;">
					输入关键字：<input id="searchInput" type="text" name="searchKey" />
					&nbsp;&nbsp; 
					<input type="checkbox" name="exactFlag" value="exact">精确查询
					&nbsp;&nbsp; 
					<input type="submit" value="查询" onclick="return checkKey();" /> 
				</div>

				<div class="header_content" style="right: 30px;">
					<input type="button" value="我的借书记录"
						onclick="javascrip:document.location.href='myborrow.action'" />
					<input type="button" value="修改个人信息" onclick="return showEdit();" />
					<input type="button" value="退出登录"
						onclick="javascript:document.location.href='login.jsp';" />
				</div>

				<div class="header_content" style="left: 30px;top:40px">
					<font style="font-size:50px;font:宋体" >
						<s:property value="user.userName"/>
					</font>
				</div> 
				<div class="header_content" style="left: 150px;top:70px">
					<font style="font-size:20px;font:宋体">欢迎你！</font>
				</div> 
			</form>
		</div>

		<div id="content">
			<center>
				 <s:if test="books==null||books.size<1">
					<br><br><br><br>
					<font style="font-size:20px;">搜索不到结果！请调整你的关键字重试 </font>				
				</s:if>
				<s:else> 
					<table>
						<tr>
							<th>书号</th>
							<th>书名</th>
							<th>余量</th>
							<th>位置</th>
							<th>出版社</th>
							<th>操作</th>
						</tr>
						<s:iterator value="books" var="book">
							<tr>
								<td><s:property value="#book.id" /></td>
								<td><s:property value="#book.bookName" /></td>
								<td><s:property value="#book.bookNum" /></td>
								<td><s:property value="#book.bookPosition" /></td>
								<td><s:property value="#book.press.name" /></td>
								<td><a href="borrowbook.action?bookId=<s:property value="#book.id"/>">
								借书</a></td>
							</tr>
						</s:iterator>
					</table>
				 </s:else> 
			</center>
		</div>

		<div id="footer">
			<p>Copyright @ 2016 13级计科8班-凡帅 -3113006116.</p>
		</div>
	</div>
	<%
		String flag = (String)session.getAttribute("");
	 %>

</body>
<script type="text/javascript">
	function showEdit() {
		document.getElementById("editForm").style.display = 'block';
	}
	function closeEdit() {
		document.getElementById("editForm").style.display = 'none';
	}
	function checkKey(){
		if (document.getElementById("searchInput").value == "") {
			alert("关键字内容不能为空");
			return false;
		}
		return true;
	}
	function checkForm() {
		var pass = new String;
		pass = document.getElementById("password").value;
		if (document.getElementById("unit").value == "") {
			alert("单位内容不能为空");
			return false;
		}else if(pass == ""||pass.length<6){
			alert("密码必须是长度不小于6的字符串");
			return false;
		}
		return true;
	}
</script>
</html>
