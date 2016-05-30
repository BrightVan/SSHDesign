<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加出版社失败</title>
    
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
			<p style="font-size:50px">图书借阅管理系统</p>
		</div>
		
		<!-- 中间内容 -->
		<div id="content" >
		   <center>
		    	<p style="font-size:25px;color:black">添加出版社失败，该出版社已存在！</p>
		    	<input style="background:#18d100;" class="button" type="button" value="返回出版社管理界面"
		    	onclick="javascript:document.location.href='getallpress.action';"/>
		    </center>
		</div>

	<!-- 底部内容 -->
		<div id="footer" >
			<p>Copyright @ 2016 13级计科8班-凡帅 -3113006116.</p>
		</div>
	</div>
  </body>
</html>
