<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑用户信息页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="main.css">
	<link rel="icon" href="res/ic_logo.png" type="image/x-icon"/>

  </head>
  
  <body>
     <div id="container">
     
    	<!-- 头部内容 -->
		<div id="header" >
			<p style="font-size:50px">编辑用户信息</p>
		</div>
		
		<!-- 中间内容 -->
		<div id="content" >
		   <center>
		   		<form action="edituserinfo.action" method="post">
						<font style="font-size:20px;font: 黑体;font-weight:bold">
						<s:property value="user.userName"/>
						</font> 
						<input type="hidden" name="user.id" 
						value="<s:property value="user.id"/>"/>
						<input type="hidden" name="user.admin" 
						value="<s:property value="user.admin"/>"/>
						<input type="hidden" name="user.userName" 
						value="<s:property value="user.userName"/>"/>
						<br><br>
						<input id="userpass" name="user.userPass" class="text"
							type="text" placeholder="输入密码"
							style="background: url(res/ic_lock.png)no-repeat 6px center" 
							value="<s:property value="user.userPass"/>"/> 
						<br><br> 
						<input id="userunit" name="user.userUnit"
							class="text" type="text" placeholder="输入所在单位"
							style="background: url(res/ic_location.png)no-repeat 6px center" 
							value="<s:property value="user.userUnit"/>"/>
						<br><br><br>
						<input style="background:#1799ea;" class="button"
							type="submit" value="修改" onclick="return checkInput();"/>
				</form>
		    </center>
		</div>

	<!-- 底部内容 -->
		<div id="footer" >
			<p>Copyright @ 2016 13级计科8班-凡帅 -3113006116.</p>
		</div>
	</div>
  </body>
  <script type="text/javascript">
  		function checkInput(){
		 var pass = new String;
	    pass = document.getElementById("userpass").value;
		if(pass == ""||pass.length<6){
			alert("密码必须是长度不小于6的字符串");
			return false;
		}else if(document.getElementById("userunit").value == ""){
			alert("所在单元不能为空");
			return false;
		}
		return true;
	}
  </script>
</html>
