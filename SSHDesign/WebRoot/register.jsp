<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="main.css">
	<link rel="stylesheet" type="text/css" href="login.css">
	<link rel="icon" href="res/ic_logo.png" type="image/x-icon"/>

  </head>
  <body>

	<div id="container">
		<div id="header">
			<p style="font-size:50px">图书借阅管理系统</p>
		</div>

		<div id="login_content">
		    <img alt="A screenshot showing CSS Quick Edit" src="res/background.jpg" />
		    <form action="myregister.action" method="post" >
		        <div class="input">
		            <font style="font-size:20px;font: 黑体;font-weight:bold">用户注册</font><br><br>
		            <input style="background: url(res/ic_account.png)no-repeat 6px center" class="text" 
		            placeholder="输入用户名" type="text" name="user.userName" id="username"
		            />
		            <br><br> 
		            <input style="background: url(res/ic_lock.png)no-repeat 6px center " class="text" 
		            placeholder="输入密码" type="password" name="user.userPass" id="password"
		            />
		            <br> <br>
		            <input style="background: url(res/ic_location.png)no-repeat 6px center " class="text" 
		            placeholder="输入所在单元" type="text" name="user.userUnit" id="unit"
		            />
		            <br><br><br> 
		            <input class="button" type="submit" value="注册" style="background:#1799ea;"
		            onclick="return checkForm();"/>
		        </div>
		    </form>
		</div>

		<div id="footer">
			<p>Copyright @ 2016 13级计科8班-凡帅 -3113006116.</p>
		</div>
	</div>
	
</body>
<script type="text/javascript">
	function checkForm() {
	    var pass = new String;
	    pass = document.getElementById("password").value;
		if (document.getElementById("username").value == "") {
			alert("用户名不能为空");
			return false;
		}else if(pass == ""||pass.length<6){
			alert("密码必须是长度不小于6的字符串");
			return false;
		}else if(document.getElementById("unit").value == ""){
			alert("所在单元不能为空");
			return false;
		}
		return true;
	}
</script>
</html>
