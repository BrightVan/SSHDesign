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

<title>图书借阅管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" href="main.css" rel="stylesheet">
<link type="text/css" href="login.css" rel="stylesheet">
<link rel="icon" href="res/ic_logo.png" type="image/x-icon"/>
</head>

<body>
	
 	<!-- 登录失败弹出的自定义窗体 -->
	<div id="error" class="hideform" style="width:30%;height:200px;">
		<img class="closeimg" alt="关闭" src="res/ic_close.png" onclick="return closeError();">
		<div class="input">
			<font style="font-size:20px;font: 黑体;font-weight:bold;color:red;">登录失败</font>
			<br><br>
			<font style="font-size:18px;font: 黑体;">请检查你的用户名和密码重试！</font>
		</div>
	</div>

	<div id="container">
		<div id="header">
			<p style="font-size:50px">图书借阅管理系统</p>
		</div>

		<div id="login_content">
		    <img alt="A screenshot showing CSS Quick Edit" src="res/background.jpg" />
		    <form action="mylogin.action" method="post" >
		        <div class="input">
		            <font style="font-size:20px;font: 黑体;font-weight:bold">用户登录</font><br><br>
		            <input style="background: url(res/ic_account.png)no-repeat 6px center" class="text" 
		            placeholder="输入用户名" type="text" name="user.userName" id="username"
		            />
		            <br><br> 
		            <input style="background: url(res/ic_lock.png)no-repeat 6px center " class="text" 
		            placeholder="输入密码" type="password" name="user.userPass" id="password"
		            />
		            <br> <br>
		            <input type="radio" name="isAdmin"  value="admin"/>管理员
		            <input type="radio" name="isAdmin"  value="normal" checked="checked"/>普通用户
		            <br><br> 
		            <input class="button" type="submit" value="登录" style="background:#18d100;" 
		            onclick="return checkForm();"
		            />
		            <br> <br> 
		            <input class="button" type="button" value="注册" style="background:#1799ea;" 
		            onclick="javascript:document.location.href='register.jsp';"
		            />
		        </div>
		    </form>
		</div>
		
		<div id="footer">
			<p>Copyright @ 2016 13级计科8班-凡帅 -3113006116.</p>
		</div>
	</div>
	
</body>
<script type="text/javascript">
	
	function showError() {
		document.getElementById("error").style.display = 'block';
	}
	function closeError() {
		document.getElementById("error").style.display = 'none';
	}
	function error(){
		alert("登录失败！请检查用户名和密码重试");
	}
	function checkForm() {
		var pass = new String;
	 	pass = document.getElementById("password").value;
		if (document.getElementById("username").value == "") {
			alert("用户名内容不能为空");
			return false;
		}else if(pass == ""||pass.length<6){
			alert("密码必须是长度大于6的字符串");
			return false;
		}
		return true;
	}
</script>
</html>
