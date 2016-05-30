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

<title>管理员主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="main.css">
<link rel="icon" href="res/ic_logo.png" type="image/x-icon" />

</head>

<body>
	<!-- 添加图书的窗体和表单 -->
	<div id="addBook" class="hideform">
		<img class="closeimg" alt="关闭" src="res/ic_close.png"
			onclick="return closeAddBook();">
		<form action="addbook.action" method="post">
			<div class="input">
				<font style="font-size:20px;font: 黑体;font-weight:bold">添加图书</font> <br>
				<br> <select name="pressName" title="选择出版社"
					style="background: url(res/ic_location.png)no-repeat 6px center">
					<s:iterator value="presses" var="press">
						<option><s:property value="#press.name" /></option>
					</s:iterator>
				</select> <br>
				<br> <input id="booknum" name="book.bookNum" class="text"
					type="text" placeholder="输入书的数量"
					style="background: url(res/ic_lock.png)no-repeat 6px center" /> <br>
				<br> <input id="bookname" name="book.bookName" class="text"
					type="text" placeholder="输入书名"
					style="background: url(res/ic_lock.png)no-repeat 6px center" /> <br>
				<br> <input id="bookposition" name="book.bookPosition"
					class="text" type="text" placeholder="输入所在位置"
					style="background: url(res/ic_location.png)no-repeat 6px center" />
				<br>
				<br>
				<br> <input style="background:#1799ea;" class="button"
					type="submit" value="添加">
			</div>
		</form>
	</div>

	<!-- <div id="mask" style="position:absolute;width:100%;height:870px;
	background-color:rgba(0,0,0,.5);z-index:990;"></div> 
	-->
	<div id="container">
		<div id="header">
			<form action="mysearchbooks.action" method="get">
				<div class="header_content" style="left: 30%;">
					输入关键字：<input id="searchInput" type="text" name="searchKey" />
					&nbsp;&nbsp; <input type="checkbox" name="exactFlag" value="exact">精确查询
					&nbsp;&nbsp; <input type="submit" value="查询"
						onclick="return checkKey();" /> &nbsp;&nbsp; &nbsp;&nbsp; <input
						type="button" value="用户管理"
						onclick="javascript:document.location.href='getalluser.action';" />
					<input type="button" value="出版社管理"
						onclick="javascript:document.location.href='getallpress.action';" />
				</div>

				<div class="header_content" style="right: 30px;top:170px;">
					<input type="button" value="添加图书" onclick="return showAddBook();" />
				</div>

				<div class="header_content" style="right: 30px;">
					<input type="button" value="查看借书记录"
						onclick="javascrip:document.location.href='getallborrow.action'" />
					<input type="button" value="退出登录"
						onclick="javascript:document.location.href='login.jsp';" />
				</div>

				<div class="header_content" style="left: 30px;top:40px">
					<font style="font-size:50px;font:宋体"> <s:property
							value="user.userName" />
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
								<td><a href="goedit.action?bookId=<s:property value="#book.id"/>">
								编辑</a></td>
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

</body>
<script type="text/javascript">
	/* window.onload=function(){//页面加载时调用的js
		
	}  */
	function showAddBook() {
		document.getElementById("bookname").value = "";
		document.getElementById("booknum").value = "";
		document.getElementById("bookposition").value = "";
		document.getElementById("addBook").style.display = 'block';
	}
	function closeAddBook() {
		document.getElementById("addBook").style.display = 'none';
	}
	function checkKey() {
		if (document.getElementById("searchInput").value == "") {
			alert("关键字内容不能为空");
			return false;
		}
		return true;
	}
</script>
</html>
